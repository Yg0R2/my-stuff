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
package yg0r2.spring.core;

/**
 * @author Yg0R2
 */
public class BaseBean {

	private String _message;

	/**
	 * Print the _message
	 */
	public void getMessage() {
		System.out.println("Your message: " + _message);
	}

	/**
	 * @param message the _message to set
	 */
	public void setMessage(String message) {
		_message = message;
	}

}
