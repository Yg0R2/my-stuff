/**
 * 
 */
package yg0r2.java8.lambda;


/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 */
public class Main2 {

	public final static String salutation = "Hello! ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GreatingService greatingService = message -> System.out.println(salutation + message);

		greatingService.sayMessage("Mahesh");
	}

	interface GreatingService {
		void sayMessage(String message);
	}

}
