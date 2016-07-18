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
package yg0r2.kata.chop;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class ChopTest {

	private Chop _underTest;

	@Test
	public void testSearch1() {
		// GIVEN in setUp

		// WHEN
		_underTest = new Chop();

		// THEN
		assertEquals(-1, _underTest.search1(3, Arrays.asList(new Integer[] {})));
		assertEquals(-1, _underTest.search1(3, Arrays.asList(new Integer[] { 1 })));
		assertEquals(0, _underTest.search1(1, Arrays.asList(new Integer[] { 1 })));

		assertEquals(0, _underTest.search1(1, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(1, _underTest.search1(3, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(2, _underTest.search1(5, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search1(0, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search1(2, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search1(4, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search1(6, Arrays.asList(new Integer[] { 1, 3, 5 })));

		assertEquals(0, _underTest.search1(1, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(1, _underTest.search1(3, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(2, _underTest.search1(5, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(3, _underTest.search1(7, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search1(0, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search1(2, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search1(4, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search1(6, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search1(8, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
	}

	@Test
	public void testSearch2() {
		// GIVEN in setUp

		// WHEN
		_underTest = new Chop();

		// THEN
		assertEquals(-1, _underTest.search2(3, Arrays.asList(new Integer[] {})));
		assertEquals(-1, _underTest.search2(3, Arrays.asList(new Integer[] { 1 })));
		assertEquals(0, _underTest.search2(1, Arrays.asList(new Integer[] { 1 })));

		assertEquals(0, _underTest.search2(1, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(1, _underTest.search2(3, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(2, _underTest.search2(5, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search2(0, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search2(2, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search2(4, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search2(6, Arrays.asList(new Integer[] { 1, 3, 5 })));

		assertEquals(0, _underTest.search2(1, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(1, _underTest.search2(3, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(2, _underTest.search2(5, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(3, _underTest.search2(7, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search2(0, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search2(2, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search2(4, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search2(6, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search2(8, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
	}

	@Test
	public void testSearch3() {
		// GIVEN in setUp

		// WHEN
		_underTest = new Chop();

		// THEN
		assertEquals(-1, _underTest.search3(3, Arrays.asList(new Integer[] {})));
		assertEquals(-1, _underTest.search3(3, Arrays.asList(new Integer[] { 1 })));
		assertEquals(0, _underTest.search3(1, Arrays.asList(new Integer[] { 1 })));

		assertEquals(0, _underTest.search3(1, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(1, _underTest.search3(3, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(2, _underTest.search3(5, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search3(0, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search3(2, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search3(4, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search3(6, Arrays.asList(new Integer[] { 1, 3, 5 })));

		assertEquals(0, _underTest.search3(1, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(1, _underTest.search3(3, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(2, _underTest.search3(5, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(3, _underTest.search3(7, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search3(0, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search3(2, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search3(4, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search3(6, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search3(8, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
	}

	@Test
	public void testSearch4() {
		// GIVEN in setUp

		// WHEN
		_underTest = new Chop();

		// THEN
		assertEquals(-1, _underTest.search4(3, Arrays.asList(new Integer[] {})));
		assertEquals(-1, _underTest.search4(3, Arrays.asList(new Integer[] { 1 })));
		assertEquals(0, _underTest.search4(1, Arrays.asList(new Integer[] { 1 })));

		assertEquals(0, _underTest.search4(1, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(1, _underTest.search4(3, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(2, _underTest.search4(5, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search4(0, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search4(2, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search4(4, Arrays.asList(new Integer[] { 1, 3, 5 })));
		assertEquals(-1, _underTest.search4(6, Arrays.asList(new Integer[] { 1, 3, 5 })));

		assertEquals(0, _underTest.search4(1, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(1, _underTest.search4(3, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(2, _underTest.search4(5, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(3, _underTest.search4(7, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search4(0, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search4(2, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search4(4, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search4(6, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
		assertEquals(-1, _underTest.search4(8, Arrays.asList(new Integer[] { 1, 3, 5, 7 })));
	}

}
