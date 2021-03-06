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
package yg0r2.designpattern.bridge;

/**
 * @author Yg0R2
 */
public class Circle extends Shape {

	private int _radius, _x, _y;

	protected Circle(int radius, int x, int y, DrawAPI drawAPI) {
		super(drawAPI);

		_radius = radius;

		_x = x;

		_y = y;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.bridge.Shape#draw()
	 */
	@Override
	public void draw() {
		drawAPI.drawCircle(_radius, _x, _y);
	}

}
