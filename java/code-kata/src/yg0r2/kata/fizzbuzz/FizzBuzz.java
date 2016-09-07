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
package yg0r2.kata.fizzbuzz;

/**
 * @author Yg0R2
 * @See http://www.codekatas.org/casts/code-kata-fizzbuzz-by-lets-develop
 */
public class FizzBuzz {

	public String getAnswerFor(int n) {
		_checkParameters(n);

		if ((n % 3 == 0) && (n % 5 == 0)) {
			return "FizzBuzz";
		}
		else if (n % 3 == 0) {
			return "Fizz";
		}
		else if (n % 5 == 0) {
			return "Buzz";
		}

		return String.valueOf(n);
	}

	private void _checkParameters(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be bigger than 1");
		}
	}

}
