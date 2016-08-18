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
