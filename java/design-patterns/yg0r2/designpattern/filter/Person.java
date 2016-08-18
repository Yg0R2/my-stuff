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
package yg0r2.designpattern.filter;

/**
 * @author Yg0R2
 */
public class Person {

	private String _gender;
	private String _maritalStatus;
	private String _name;

	public Person(String name, String gender, String maritalStatus) {
		_gender = gender;
		_maritalStatus = maritalStatus;
		_name = name;
	}

	public String getGender() {
		return _gender;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public String getName() {
		return _name;
	}

}
