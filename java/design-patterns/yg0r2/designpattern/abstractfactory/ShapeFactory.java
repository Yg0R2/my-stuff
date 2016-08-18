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
		}
		else if (shape.equals("RECTANGLE")) {
			return new Rectangle();
		}
		else if (shape.equals("SQUARE")) {
			return new Square();
		}

		return null;
	}

}
