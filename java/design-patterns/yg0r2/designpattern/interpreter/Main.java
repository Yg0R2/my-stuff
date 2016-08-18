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
package yg0r2.designpattern.interpreter;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/interpreter_pattern.htm
 */
public class Main {

	// Rule: Robert and John are male
	public static Expression getMaleExpression() {
		Expression robertExpression = new TerminalExpression("Robert");
		Expression johnExpression = new TerminalExpression("John");

		return new OrExpression(robertExpression, johnExpression);
	}

	// Rule: Julie is a married women
	public static Expression getMarriedWomanExpression() {
		Expression julieExpression = new TerminalExpression("Julie");
		Expression marriedExpression = new TerminalExpression("married");

		return new AndExpression(julieExpression, marriedExpression);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("married Julie"));
	}

}
