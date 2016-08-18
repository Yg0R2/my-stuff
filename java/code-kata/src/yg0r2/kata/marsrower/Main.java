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

/**
 * @author Yg0R2
 *
 * Description:
 *
 * <ul>
 *  <li>Develop an API that moves a rover around on a grid.</li>
 *  <li>You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.</li>
 *  <li>The rover receives a character array of commands.</li>
 *  <li>Implement commands that move the rover forward/backward (f,b).</li>
 *  <li>Implement commands that turn the rover left/right (l,r).</li>
 *  <li>Implement wrapping from one edge of the grid to another. (planets are spheres after all)</li>
 *  <li>Implement obstacle detection before each move to a new square.
 *   <ul>
 *    <li>If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and
 *      reports the obstacle.</li>
 *   </ul>
 *  </li>
 * </ul>
 *
 * Example:
 * <ul>
 *  <li>The rover is on a 100x100 grid at location (0, 0) and facing NORTH.</li>
 *  <li>The rover is given the commands "ffrff" and should end up at (2, 2)</li>
 * </ul>
 *
 * Tips:
 *  <ul>
 *   <li>Use multiple classes and TDD</li>
 *  </ul>
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] commands = "FFFLFFF".toCharArray();

		Grid grid = new Grid(10, 5, 0);

		Rower rower = new Rower('N', grid);

		grid.printGrid();

		rower.move(commands);

		grid.printGrid();
	}

}
