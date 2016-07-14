/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package yg0r2.epam.advanced_concurrency.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 */
public class Account {

	private static Logger _logger = LoggerFactory.getLogger(Account.class);

	private int _balance;
	private Lock _lock;

	public Account(int initialBalance) {
		_balance = initialBalance;

		_lock = new ReentrantLock();
	}

	public void withdraw(int amount) {
		_balance -= amount;

		_logger.info("After withdraw, the new balance = " + _balance);
	}

	public void deposit(int amount) {
		_balance += amount;

		_logger.info("After deposit, the new balance = " + _balance);
	}

	public int getBalance() {
		return _balance;
	}

	public Lock getLock() {
		return _lock;
	}

}
