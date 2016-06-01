/**
 * 
 */
package yg0r2.java8.lambda;


/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main instance = new Main();

		// With type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// Without type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// With return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> { return a * b; };

		// Without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + instance._operate(10, 5, addition));
		System.out.println("10 - 5 = " + instance._operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + instance._operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + instance._operate(10, 5, division));

		// Without parenthesis
		GettingService gettingService1 = message -> System.out.println("Hello " + message);

		// With parenthesis
		GettingService gettingService2 = (message) -> System.out.println("Hello " + message);

		gettingService1.sayMessage("Mahesh");
		gettingService2.sayMessage("Suresh");
	}

	private int _operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}


	interface GettingService {
		void sayMessage(String message);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

}
