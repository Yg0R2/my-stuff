/**
 * 
 */
package yg0r2.kata.marsrower;

/**
 * @author Yg0R2
 */
public class Rower {

	private static boolean _debugEnabled = false;

	private Grid _grid;
	private char _orientation;

	/**
	 * Rower constructor.
	 *
	 * @param orientation <b>orientation</b> on the grid.
	 * @throws ObstacleException 
	 */
	public Rower(char orientation, Grid grid) {
		_grid = grid;
		_orientation = Character.toUpperCase(orientation);

		try {
			_grid.moveCoordinate(0, 0);
		} catch (Exception e) {
		}
	}

	public char getOrientation() {
		return _orientation;
	}

	public void move(char[] commands) {
		StringBuilder successMoveCommands = new StringBuilder(commands.length);

		try {
			for (char command : commands) {
				if (_debugEnabled) {
					_grid.printGrid();
				}

				command = Character.toUpperCase(command);

				if (command == 'B') {
					_moveBackward();
				} else if (command == 'F') {
					_moveForward();
				} else if (command == 'L') {
					_turnLeft();
				} else if (command == 'R') {
					_turnRight();;
				} else {
					throw new RuntimeException("Not valid command: " + command);
				}

				successMoveCommands.append(command);
			}
		} catch (ObstacleException e) {
			System.out.println("Rower blocked by an obstacle.");
			System.out.println("All commands commands :" + new String(commands));
			System.out.println("Executed commands     :" + successMoveCommands.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void _moveBackward() throws Exception {
		if (_orientation == 'N') {
			_grid.moveCoordinate(0, 1);
		} else if (_orientation == 'S') {
			_grid.moveCoordinate(0, -1);
		} else if (_orientation == 'W') {
			_grid.moveCoordinate(1, 0);
		} else if (_orientation == 'E') {
			_grid.moveCoordinate(-1, 0);
		}
	}

	private void _moveForward() throws Exception {
		if (_orientation == 'N') {
			_grid.moveCoordinate(0, -1);
		} else if (_orientation == 'S') {
			_grid.moveCoordinate(0, 1);
		} else if (_orientation == 'W') {
			_grid.moveCoordinate(-1, 0);
		} else if (_orientation == 'E') {
			_grid.moveCoordinate(1, 0);
		}
	}

	private void _turnLeft() {
		if (_orientation == 'N') {
			_orientation = 'W';
		} else if (_orientation == 'S') {
			_orientation = 'E';
		} else if (_orientation == 'W') {
			_orientation = 'S';
		} else if (_orientation == 'E') {
			_orientation = 'N';
		}
	}

	private void _turnRight() {
		if (_orientation == 'N') {
			_orientation = 'E';
		} else if (_orientation == 'S') {
			_orientation = 'W';
		} else if (_orientation == 'W') {
			_orientation = 'N';
		} else if (_orientation == 'E') {
			_orientation = 'S';
		}
	}

}