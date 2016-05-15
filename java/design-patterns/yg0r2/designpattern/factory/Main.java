/**
 * 
 */
package yg0r2.designpattern.factory;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		//get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		//call draw method of Circle
		shape1.draw();

		//get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		//call draw method of Rectangle
		shape2.draw();

		//get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");

		//call draw method of circle
		shape3.draw();
	}

}