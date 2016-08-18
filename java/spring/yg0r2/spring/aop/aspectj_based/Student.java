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
package yg0r2.spring.aop.aspectj_based;

/**
 * @author Yg0R2
 */
public class Student {

	private Integer _age;
	private String _name;

	/**
	 * @return the _age
	 */
	public Integer getAge() {
		System.out.println("Age: " + _age);

		return _age;
	}

	/**
	 * @return the _name
	 */
	public String getName() {
		System.out.println("Name: " + _name);

		return _name;
	}

	public void printThrowException() {
		System.out.println("Exception raised.");

		throw new IllegalArgumentException();
	}

	/**
	 * @param age the _age to set
	 */
	public void setAge(Integer age) {
		_age = age;
	}

	/**
	 * @param name the _name to set
	 */
	public void setName(String name) {
		_name = name;
	}
}
