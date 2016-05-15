/**
 * 
 */
package yg0r2.kata.marsrower;

import java.lang.reflect.Field;

import jodd.bean.BeanUtil;

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
		StringBuilder[] gridArray = (StringBuilder[]) BeanUtil.getDeclaredProperty(grid, "_grid");

		StringBuilder line = gridArray[coordinateY];

		return line.charAt(coordinateX);
	}

}