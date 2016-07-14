package yg0r2.epam.advanced_concurrency.bank;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Transfer implements Callable<Boolean> {

	private static Logger _logger = LoggerFactory.getLogger(Transfer.class);
	private static long WAIT_SEC = 10;

	private Account _accFrom;
	private Account _accTo;
	private int _amount;

	public Transfer(Account accFrom, Account accTo, Integer amount) {
		_accFrom = accFrom;
		_accTo = accTo;
		_amount = amount;
	}

	@Override
	public Boolean call() throws Exception {
		if (_accFrom.getBalance() < _amount) {
			throw new IllegalArgumentException("Insufficient found ");
		}

		if (_accFrom.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
			try {
				if (_accTo.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
					try {
						_accFrom.withdraw(_amount);
						_accTo.deposit(_amount);
					}
					finally {
						_accTo.getLock().unlock();
					}
				}
				else {
					return false;
				}
			}
			finally {
				_accFrom.getLock().unlock();
			}
		}
		else {
			return false;
		}

		_logger.info("Account 1 balance: " + _accFrom.getBalance());
		_logger.info("Account 2 balance: " + _accTo.getBalance());

		return true;
	}

	public Boolean perform() {
		try {
			return call();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
