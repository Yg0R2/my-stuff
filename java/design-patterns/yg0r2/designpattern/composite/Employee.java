/**
 * 
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