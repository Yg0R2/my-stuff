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

import java.util.ArrayList;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class SupermarketTest {

	private Supermarket _underTest;

	@Test
	public void testConstructor() throws InvalidAttributeValueException {
		new Supermarket(TestUtils.aListOfItems(), 100);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorEmptyList() throws InvalidAttributeValueException {
		new Supermarket(new ArrayList<>(), 100);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorNegativeBudget() throws InvalidAttributeValueException {
		new Supermarket(TestUtils.aListOfItems(), -100);
	}

	@Test
	public void testSellItem() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Supermarket(TestUtils.aListOfItems(), 100);

		// THEN
		_underTest.sellItem("Test Item1 Name", 1);
		assertEquals(9, _underTest.getStock("Test Item1 Name").intValue());
		assertEquals(110.4, _underTest.getBudget().doubleValue(), 0.0);

		_underTest.sellItem("Test Item2 Name", 4);
		assertEquals(6, _underTest.getStock("Test Item2 Name").intValue());
		assertEquals(152, _underTest.getBudget().doubleValue(), 0.0);
	}

	@Test
	public void testSellOnSaleItem() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Supermarket(TestUtils.aListOfOnSaleItems(), 100);

		// THEN
		_underTest.sellItem("Test Item1 Name", 1);
		assertEquals(9, _underTest.getStock("Test Item1 Name").intValue());
		assertEquals(110.4, _underTest.getBudget().doubleValue(), 0.0);

		_underTest.sellItem("Test Item2 Name", 4);
		assertEquals(6, _underTest.getStock("Test Item2 Name").intValue());
		assertEquals(150, _underTest.getBudget().doubleValue(), 0.0);
	}

}
