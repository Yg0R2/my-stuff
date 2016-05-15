/**
 * 
 */
package yg0r2.designpattern.abstractfactory;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class ColorFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.abstractfactory.AbstractFactory#getColor(java.lang.String)
	 */
	@Override
	public Color getColor(String color) {
		if (Validator.isNull(color)) {
			return null;
		}

		if (color.equals("BLUE")) {
			return new Blue();
		} else if (color.equals("GREEN")) {
			return new Green();
		} else if (color.equals("RED")) {
			return new Red();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.abstractfactory.AbstractFactory#getShape(java.lang.String)
	 */
	@Override
	public Shape getShape(String shape) {
		return null;
	}

}