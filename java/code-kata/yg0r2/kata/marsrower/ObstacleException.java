/**
 * 
 */
package yg0r2.kata.marsrower;

/**
 * @author Yg0R2
 */
public class ObstacleException extends Exception {

	/**
	 *
	 */
	public ObstacleException() {
		super();
	}

	/**
	 * @param message
	 */
	public ObstacleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ObstacleException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ObstacleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ObstacleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}