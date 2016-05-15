/**
 * 
 */
package yg0r2.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yg0R2
 */
public class ShapeFactory {

	private static final Map<String, Shape> _shapeMap = new HashMap<>();

	public static Shape getCircle(String color) {
		if (_shapeMap.containsKey(color)) {
			return _shapeMap.get(color);
		}

		Circle circle = new Circle(color);

		_shapeMap.put(color, circle);

		System.out.println("Create circle of color : " + color);

		return circle;
	}

}