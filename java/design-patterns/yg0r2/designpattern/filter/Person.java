/**
 * 
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