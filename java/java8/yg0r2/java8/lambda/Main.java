/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package yg0r2.java8.lambda;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 */
public class Main {

	interface GettingService {

		void sayMessage(String message);
	}

	interface MathOperation {

		int operation(int a, int b);
	}

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
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

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

}
