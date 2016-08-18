/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
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
