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
package yg0r2.kata.marsrower;

import java.lang.reflect.Field;

/**
 * @author Yg0R2
 */
public class MarsRowerTestUtil {

	public static Grid generateCleanGrid(int size, int rowerX, int rowerY) {
		try {
			Field field = Grid.class.getDeclaredField("_generateObstacles");

			field.setAccessible(true);

			field.set(null, false);
		}
		catch (Exception e) {
		}

		return new Grid(size, rowerX, rowerY);
	}

	public static char getGridChar(Grid grid, int coordinateX, int coordinateY) {
		StringBuilder[] gridArray = null;

		try {
			Field field = grid.getClass().getDeclaredField("_grid");
			field.setAccessible(true);

			gridArray = (StringBuilder[]) field.get(grid);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}

		StringBuilder line = gridArray[coordinateY];

		return line.charAt(coordinateX);
	}

}
