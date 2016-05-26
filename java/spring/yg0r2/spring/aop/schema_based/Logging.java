/**
 * 
 */
package yg0r2.spring.aop.schema_based;

/**
 * @author Yg0R2
 */
public class Logging {

	/**
	 * This is the method which I would like to execute after a selected method execution.
	 */
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(Object retValue) {
		System.out.println("Returning: " + retValue.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception raised.
	 */
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}

	/**
	 * This is the method which I would like to execute before a selected method execution.
	 */
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}
}
