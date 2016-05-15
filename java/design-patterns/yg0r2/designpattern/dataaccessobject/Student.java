/**
 * 
 */
package yg0r2.designpattern.dataaccessobject;

/**
 * @author Yg0R2
 */
public class Student {

	private String _name;
	private int _rollNo;

	public Student(String name, int rollNo) {
		_name = name;

		_rollNo = rollNo;
	}

	public String getName() {
		return _name;
	}

	public int getRollNo() {
		return _rollNo;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setRollNo(int rollNo) {
		_rollNo = rollNo;
	}

}