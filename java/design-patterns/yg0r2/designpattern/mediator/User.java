/**
 * 
 */
package yg0r2.designpattern.mediator;

/**
 * @author Yg0R2
 */
public class User {

	private String _name;

	public User(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}

	public void setName(String name) {
		_name = name;
	}

}