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
package yg0r2.kata.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class BallSortingTest {

	private BallSorting _underTest;

	@Test
	public void testAdd() {
		// GIVEN on setUp

		// THEN
		_underTest = new BallSorting();

		// WHEN
		_underTest.add(3);
		assertEquals("[3]", _underTest.toString());
		_underTest.add(2);
		assertEquals("[2, 3]", _underTest.toString());
		_underTest.add(5);
		assertEquals("[2, 3, 5]", _underTest.toString());
		_underTest.add(4);
		assertEquals("[2, 3, 4, 5]", _underTest.toString());
		_underTest.add(1);
		assertEquals("[1, 2, 3, 4, 5]", _underTest.toString());
	}

	@Test
	public void testEmptyList() {
		// GIVEN on setUp

		// THEN
		_underTest = new BallSorting();

		// WHEN
		assertEquals("[]", _underTest.toString());
	}

}
