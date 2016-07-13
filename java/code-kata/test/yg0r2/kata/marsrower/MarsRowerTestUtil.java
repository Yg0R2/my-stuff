/**
 * 
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
		} catch (Exception e) {
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