/**
 * 
 */
package yg0r2.designpattern.mediator;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}

}