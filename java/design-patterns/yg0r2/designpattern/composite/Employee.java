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
package yg0r2.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class Employee {

	private String _department;
	private String _name;
	private int _salary;
	private List<Employee> _subordinates;

	public Employee(String name, String department, int salary) {
		_department = department;
		_name = name;
		_salary = salary;

		_subordinates = new ArrayList<>();
	}

	public void add(Employee employee) {
		_subordinates.add(employee);
	}

	public List<Employee> getSubordinates() {
		return _subordinates;
	}

	public void remove(Employee employee) {
		_subordinates.remove(employee);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(7);

		sb.append("Employee:[ Name : ");
		sb.append(_name);
		sb.append(", department : ");
		sb.append(_department);
		sb.append(", salary : ");
		sb.append(_salary);
		sb.append(" ]");

		return sb.toString();
	}

}
