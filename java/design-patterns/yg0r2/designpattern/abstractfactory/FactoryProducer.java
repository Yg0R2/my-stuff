/**
 * 
 */
package yg0r2.designpattern.abstractfactory;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {
		if (Validator.isNull(choice)) {
			return null;
		}

		if (choice.equals("COLOR")) {
			return new ColorFactory();
		} else if (choice.equals("SHAPE")) {
			return new ShapeFactory();
		}

		return null;
	}

}