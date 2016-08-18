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
public class Main2 {

	interface GreatingService {

		void sayMessage(String message);
	}

	public final static String salutation = "Hello! ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GreatingService greatingService = message -> System.out.println(salutation + message);

		greatingService.sayMessage("Mahesh");
	}

}
