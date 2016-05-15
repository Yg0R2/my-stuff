/**
 * 
 */
package yg0r2.designpattern.chainofresponsibility;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
 */
public class Main {

	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");

		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
	}

}