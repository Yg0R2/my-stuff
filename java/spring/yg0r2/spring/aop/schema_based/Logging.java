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
