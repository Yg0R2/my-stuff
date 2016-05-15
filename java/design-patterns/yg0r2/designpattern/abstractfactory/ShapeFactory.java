/**
 * 
 */
package yg0r2.designpattern.abstractfactory;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class ShapeFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.abstractfactory.AbstractFactory#getColor(java.lang.String)
	 */
	@Override
	public Color getColor(String color) {
		return null;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.abstractfactory.AbstractFactory#getShape(java.lang.String)
	 */
	@Override
	public Shape getShape(String shape) {
		if (Validator.isNull(shape)) {
			return null;
		}

		if (shape.equals("CIRCLE")) {
			return new Circle();
		} else if (shape.equals("RECTANGLE")) {
			return new Rectangle();
		} else if (shape.equals("SQUARE")) {
			return new Square();
		}

		return null;
	}

}