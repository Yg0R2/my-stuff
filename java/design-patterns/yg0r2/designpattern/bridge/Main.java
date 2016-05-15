/**
 * 
 */
package yg0r2.designpattern.bridge;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape redCircle = new Circle(10, 100, 100, new RedCircle());

		redCircle.draw();

		Shape greenCircle = new Circle(10, 100, 100, new GreenCircle());

		greenCircle.draw();
	}

}