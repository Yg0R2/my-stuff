/**
 * 
 */
package yg0r2.designpattern.state;

/**
 * @author Yg0R2
 */
public class Context {

	private State _state = null;

	public Context() {
	}

	public State getState() {
		return _state;
	}

	public void setState(State state) {
		_state = state;
	}

}