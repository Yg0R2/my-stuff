/**
 * 
 */
package yg0r2.designpattern.memento;

/**
 * @author Yg0R2
 */
public class Originator {

	private String _state;

	public String getState() {
		return _state;
	}

	public void getStateFromMemento(Memento memento) {
		_state = memento.getState();
	}

	public Memento saveStateToMemento() {
		return new Memento(_state);
	}

	public void setState(String state) {
		_state = state;
	}

}