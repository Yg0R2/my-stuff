/**
 * 
 */
package yg0r2.designpattern.chainofresponsibility;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	protected int leve;

	//next element in chain or responsibility
	protected AbstractLogger nextLogger;

	protected abstract void write(String message);

	public void logMessage(int level, String message) {
		if (this.leve <= level) {
			write(message);
		}

		if (Validator.isNotNull(nextLogger)) {
			nextLogger.logMessage(level, message);
		}
	}

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

}