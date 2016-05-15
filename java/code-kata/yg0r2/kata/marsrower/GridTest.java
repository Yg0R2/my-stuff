/**
 * 
 */
package yg0r2.kata.marsrower;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yg0R2
 */
public class GridTest {

	private int _gridSize = 5;

	@Test
	public void testInitGrid() {
		Grid grid = new Grid(_gridSize, 0, 0);

		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 0, 0));

		for (int x = 1; x < _gridSize; x++) {
			for (int y = 1; y < _gridSize; y++) {
				char gridChar = MarsRowerTestUtil.getGridChar(grid, x, y);

				if (gridChar == Grid.CLEAN) {
					assertEquals(Grid.CLEAN, gridChar);
				} else {
					assertEquals(Grid.OBSTACLE, gridChar);
				}
			}
		}
	}

	@Test
	public void testInitialize() throws Exception {
		Grid grid = new Grid(_gridSize, 2, 2);

		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, 2));
	}

	@Test
	public void testMoveCoordinate() throws Exception {
		Grid grid = new Grid(_gridSize, 2, 2);

		grid.moveCoordinate(0, 1);

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, 3));
	}

}