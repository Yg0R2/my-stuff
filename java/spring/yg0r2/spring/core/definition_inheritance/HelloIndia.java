/**
 * 
 */
package yg0r2.spring.core.definition_inheritance;

/**
 * @author Yg0R2
 */
public class HelloIndia {

	private String _message1;
	private String _message2;
	private String _message3;

	/**
	 * @return the _message1
	 */
	public void getMessage1() {
		System.out.println("India message1: " + _message1);
	}

	/**
	 * @return the _message2
	 */
	public void getMessage2() {
		System.out.println("India message2: " + _message2);
	}

	/**
	 * @return the _message3
	 */
	public void getMessage3() {
		System.out.println("India message3: " + _message3);
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

	/**
	 * @param message the _message3 to set
	 */
	public void setMessage3(String message) {
		_message3 = message;
	}

}
