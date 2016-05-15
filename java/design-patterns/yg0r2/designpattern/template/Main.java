/**
 * 
 */
package yg0r2.designpattern.template;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/template_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();

		System.out.println();

		game = new Football();
		game.play();
	}

}