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
package yg0r2.kata.bloom_filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class BloomFilterTest {

	private BloomFilter<String> _underTest;

	@Test
	public void testAdd() {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.aBloomFilter();
		_underTest.add("apple");

		// THEN
		assertFalse(_underTest.isEmpty());
		assertEquals(1, _underTest.getSize());
		assertTrue(_underTest.maybeContains("apple"));
	}

	@Test
	public void testContains() {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.aBloomFilter();
		_underTest.add("apple");

		// THEN
		assertTrue(_underTest.maybeContains("apple"));
		assertFalse(_underTest.maybeContains("banana"));
	}

	@Test
	public void testConstructor() {
		// GIVEN in setUp

		// WHEN
		_underTest = new BloomFilter<String>(10, 5);

		// THEN
		assertEquals(0, _underTest.getSize());
		assertTrue(_underTest.isEmpty());
	}

}
