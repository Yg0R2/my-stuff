/**
 * 
 */
package yg0r2.designpattern.chainofresponsibility;

/**
 * @author Yg0R2
 */
public class ErrorLogger extends AbstractLogger {

	/**
	 * 
	 */
	public ErrorLogger(int level) {
		this.leve = level;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.chainofresponsibility.AbstractLogger#write(java.lang.String)
	 */
	@Override
	protected void write(String message) {
		System.out.println("ERROR [" + this.leve + "] " + message);
	}

}