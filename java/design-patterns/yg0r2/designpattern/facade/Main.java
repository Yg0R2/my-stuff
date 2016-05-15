/**
 * 
 */
package yg0r2.designpattern.facade;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/facade_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}

}