/**
 * 
 */
package yg0r2.designpattern.state;

/**
 * @author Yg0R2
 */
public class StartState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in state state");

		context.setState(this);
	}

	@Override
	public String toString() {
		return "Start State";
	}

}