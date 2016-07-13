/**
 * 
 */
package yg0r2.kata.marsrower;

/**
 * @author Yg0R2
 */
public class MissingRowerException extends Exception {

	/**
	 * 
	 */
	public MissingRowerException() {
		super();
	}

	/**
	 * @param message
	 */
	public MissingRowerException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MissingRowerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MissingRowerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MissingRowerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

}