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
package yg0r2.kata.supermarket;

import static org.junit.Assert.assertEquals;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class PriceTest {

	private Price _underTest;

	@Test
	public void testConstructor() throws InvalidAttributeValueException {
		new Price(10);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorInvalidPrice() throws InvalidAttributeValueException {
		new Price(-1);
	}

	@Test
	public void testGetPrice() {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.aPrice();

		// THEN
		assertEquals(10.4, _underTest.getPrice(1).doubleValue(), 0.0);
		assertEquals(5.2, _underTest.getPrice(0.5).doubleValue(), 0.0);
		assertEquals(15.6, _underTest.getPrice(1.5).doubleValue(), 0.0);
		assertEquals(20.8, _underTest.getPrice(2).doubleValue(), 0.0);
		assertEquals(26, _underTest.getPrice(2.5).doubleValue(), 0.0);
	}

	@Test
	public void testGetPricePerUnit() {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.aPrice();

		// THEN
		assertEquals(10.4, _underTest.getPricePerUnit().doubleValue(), 0.0);
	}

}
