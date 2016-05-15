/**
 * 
 */
package yg0r2.designpattern.factory;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class ShapeFactory {

	public Shape getShape(String shapeType) {
		if (Validator.isNull(shapeType)) {
			return null;
		}

		if (shapeType.equals("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equals("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equals("SQUARE")) {
			return new Square();
		}

		return null;
	}

}