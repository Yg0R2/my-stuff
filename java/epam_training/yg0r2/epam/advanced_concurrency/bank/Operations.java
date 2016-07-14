/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yg0r2.epam.advanced_concurrency.bank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 */
public class Operations {

	private static Logger _logger = LoggerFactory.getLogger(Operations.class);

	public static void main(String[] args) {
		final Account a = new Account(1000);
		final Account b = new Account(2000);

		new Thread(() -> transfer(a, b, 500)).start();
		transfer(b, a, 300);
	}

	public static void transfer(Account acc1, Account acc2, int amount) {
		try {
			// transferDeadlock(acc1, acc2, amount);
			// transferNotThreadSafe(acc1, acc2, amount);
			// transferJavaLock(acc1, acc2, amount);
			transferTrainingJavaLock(acc1, acc2, amount);
		}
		catch (InterruptedException e) {
			_logger.error(e.getMessage(), e);
		}
	}

	protected static void transferNotThreadSafe(Account acc1, Account acc2, int amount) {
		if (acc1.getBalance() < amount) {
			throw new IllegalArgumentException("Not enough ");
		}

		acc1.withdraw(amount);
		acc2.deposit(amount);

		_logger.info("Account 1 balance: " + acc1.getBalance());
		_logger.info("Account 2 balance: " + acc2.getBalance());
	}

	protected static void transferDeadlock(Account acc1, Account acc2, int amount) {
		if (acc1.getBalance() < amount) {
			throw new IllegalArgumentException("Not enough ");
		}

		_logger.info("Try to lock Account 1");
		synchronized (acc1) {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				_logger.error(e.getMessage(), e);
			}

			_logger.info("Try to lock Account 2");
			synchronized (acc2) {
				acc1.withdraw(amount);
				acc2.deposit(amount);
			}
		}

		_logger.info("Account 1 balance: " + acc1.getBalance());
		_logger.info("Account 2 balance: " + acc2.getBalance());
	}

	protected static void transferJavaLock(Account acc1, Account acc2, int amount) {
		if (acc1.getBalance() < amount) {
			throw new IllegalArgumentException("Not enough ");
		}

		Lock lock1 = new ReentrantLock();

		_logger.info("Try to lock Account 1");

		lock1.lock();
		try {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				_logger.error(e.getMessage(), e);
			}

			Lock lock2 = new ReentrantLock();

			_logger.info("Try to lock Account 2");

			lock2.lock();
			try {
				acc1.withdraw(amount);
				acc2.deposit(amount);
			}
			finally {
				lock2.unlock();
			}
		}
		finally {
			lock1.unlock();
		}

		_logger.info("Account 1 balance: " + acc1.getBalance());
		_logger.info("Account 2 balance: " + acc2.getBalance());
	}

	private static long WAIT_SEC = 5;

	protected static void transferTrainingJavaLock(Account acc1, Account acc2, int amount) throws InterruptedException {
		if (acc1.getBalance() < amount) {
			throw new IllegalArgumentException("Not enough ");
		}

		if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
			try {
				if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
					try {
						acc1.withdraw(amount);
						acc2.deposit(amount);
					}
					finally {
						acc2.getLock().unlock();
					}
				}
				else {
					_logger.error("Account 2 locking failed.");
				}
			}
			finally {
				acc1.getLock().unlock();
			}
		}
		else {
			_logger.error("Account 1 locking failed.");
		}

		_logger.info("Account 1 balance: " + acc1.getBalance());
		_logger.info("Account 2 balance: " + acc2.getBalance());
	}

}
