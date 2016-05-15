/**
 * 
 */
package yg0r2.designpattern.frontcontroller;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/front_controller_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FrontController frontController = new FrontController();

		frontController.dispatchRequest(Dispatcher.STUDENT);
		frontController.dispatchRequest(Dispatcher.HOME);
	}

}