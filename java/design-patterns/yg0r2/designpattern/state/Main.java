/**
 * 
 */
package yg0r2.designpattern.state;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/state_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}

}