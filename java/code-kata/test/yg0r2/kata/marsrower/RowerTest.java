/**
 * 
 */
package yg0r2.kata.marsrower;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class RowerTest {

	private int _gridSize = 5;

	@Test
	public void testInitRower() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		new Rower('N', grid);

		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, 2));
	}

	@Test
	public void testRowerMoveBackward() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'B'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, 3));
	}

	@Test
	public void testRowerMoveForward() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, 1));
	}

	@Test
	public void testRowerMoveForwardEastEdge() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, _gridSize - 1, 2);

		Rower rower = new Rower('E', grid);

		rower.move(new char[] {'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, _gridSize - 1, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 0, 2));
	}

	@Test
	public void testRowerMoveForwardNorthEdge() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 0);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 0));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, _gridSize - 1));
	}

	@Test
	public void testRowerMoveForwardSouthEdge() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, _gridSize - 1);

		Rower rower = new Rower('S', grid);

		rower.move(new char[] {'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, _gridSize - 1));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 2, 0));
	}

	@Test
	public void testRowerMoveForwardWestEdge() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 0, 2);

		Rower rower = new Rower('W', grid);

		rower.move(new char[] {'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 0, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, _gridSize - 1, 2));
	}

	@Test
	public void testRowerTornLeftAndMoveBackward() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'L', 'B'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 3, 2));
	}

	@Test
	public void testRowerTornLeftAndMoveForward() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'L', 'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 1, 2));
	}

	@Test
	public void testRowerTornRightAndMoveForward() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'R', 'B'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 1, 2));
	}

	@Test
	public void testRowerTornRightAndMoveBackward() {
		Grid grid = MarsRowerTestUtil.generateCleanGrid(_gridSize, 2, 2);

		Rower rower = new Rower('N', grid);

		rower.move(new char[] {'R', 'F'});

		assertEquals(Grid.CLEAN, MarsRowerTestUtil.getGridChar(grid, 2, 2));
		assertEquals(Grid.ROWER, MarsRowerTestUtil.getGridChar(grid, 3, 2));
	}

}