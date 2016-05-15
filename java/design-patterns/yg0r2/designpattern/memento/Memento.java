/**
 * 
 */
package yg0r2.designpattern.memento;

/**
 * @author Yg0R2
 */
public class Memento {

	private String _state;

	public Memento(String state) {
		_state = state;
	}

	public String getState() {
		return _state;
	}

}