/**
 * 
 */
package yg0r2.designpattern.transferobject;

/**
 * @author Yg0R2
 */
public class StudentTransferObject {

	private String _name;
	private int _rollNo;

	public StudentTransferObject(String name, int roleNo) {
		_name = name;

		_rollNo = roleNo;
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

	public void setRoleNo(int roleNo) {
		_rollNo = roleNo;
	}

}