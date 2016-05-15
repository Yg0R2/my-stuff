/**
 * 
 */
package yg0r2.kata.marsrower;

import java.util.Random;

import org.apache.commons.lang.StringUtils;

/**
 * @author Yg0R2
 */
public class Grid {

	public static final char CLEAN = ' ';
	public static final char OBSTACLE = 'O';
	public static final char ROWER = 'R';

	private static boolean _generateObstacles = true;

	private StringBuilder[] _grid;
	private int _gridSize;
	private int _rowerX;
	private int _rowerY;

	public Grid(int size, int rowerX, int rowerY) {
		if (size < 3) {
			throw new RuntimeException("Grid size must be greater than 3.");
		}

		_gridSize = size;

		_rowerX = rowerX;
		_rowerY = rowerY;

		_initGrid();
	}

	public void moveCoordinate(int orientationX, int orientationY) throws Exception {
		int toX = _normalizeCoordinate(_rowerX + orientationX);
		int toY = _normalizeCoordinate(_rowerY + orientationY);

		StringBuilder line = _grid[_rowerY];

		// Ignore while settling the rower
		if ((_rowerX != toX) || (_rowerY != toY)) {
			if ((line.charAt(_rowerX) != ROWER)) {
				throw new MissingRowerException("Rower is not in the current position.");
			}

			if (line.charAt(toX) == OBSTACLE) {
				throw new ObstacleException();
			}
		}

		line.setCharAt(_rowerX, CLEAN);

		if (_rowerY != toY) {
			line = _grid[toY];

			if (line.charAt(toX) == OBSTACLE) {
				throw new ObstacleException();
			}
		}

		line.setCharAt(toX, ROWER);

		_rowerX = toX;
		_rowerY = toY;
	}

	public void printGrid() {
		System.out.println(StringUtils.repeat("-", _gridSize));

		for (int i = 0; i < _gridSize; i++) {
			System.out.println(_grid[i].toString());
		}

		System.out.println(StringUtils.repeat("-", _gridSize));
	}

	private void _initGrid() {
		_grid = new StringBuilder[_gridSize];

		for (int i = 0; i < _gridSize; i++) {
			_grid[i] = new StringBuilder(StringUtils.repeat(" ", _gridSize));
		}

		if (_generateObstacles) {
			Random rnd = new Random();

			for (int i = 0; i < _gridSize; i++) {
				int x = rnd.nextInt(_gridSize);
				int y = rnd.nextInt(_gridSize);

				StringBuilder line = _grid[x];

				if (line.charAt(y) != OBSTACLE) {
					line.setCharAt(y, OBSTACLE);
				}
			}
		}

		StringBuilder line = _grid[_rowerY];

		line.setCharAt(_rowerX, ROWER);
	}

	private int _normalizeCoordinate(int c) {
		while (true) {
			if (c >= 0) {
				break;
			}

			// c is negative

			c += _gridSize;
		}

		while (true) {
			if (c < _gridSize) {
				break;
			}

			c -= _gridSize;
		}

		return c;
	}

}