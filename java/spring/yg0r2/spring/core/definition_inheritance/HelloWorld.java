/**
 * 
 */
package yg0r2.spring.core.definition_inheritance;

/**
 * @author Yg0R2
 */
public class HelloWorld {

	private String _message1;
	private String _message2;

	/**
	 * @return the _message1
	 */
	public void getMessage1() {
		System.out.println("World message1: " + _message1);
	}

	/**
	 * @return the _message2
	 */
	public void getMessage2() {
		System.out.println("World message2: " + _message2);
	}

	/**
	 * @param message the _message1 to set
	 */
	public void setMessage1(String message) {
		_message1 = message;
	}

	/**
	 * @param message the _message2 to set
	 */
	public void setMessage2(String message) {
		_message2 = message;
	}

}
