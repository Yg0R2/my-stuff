/**
 * 
 */
package yg0r2.spring.core;

/**
 * @author Yg0R2
 */
public class BaseBean {

	private String _message;

	/**
	 * Print the _message
	 */
	public void getMessage() {
		System.out.println("Your message: " + _message);
	}

	/**
	 * @param message the _message to set
	 */
	public void setMessage(String message) {
		_message = message;
	}

}
