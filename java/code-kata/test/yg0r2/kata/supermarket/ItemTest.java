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

import java.math.BigDecimal;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class ItemTest {

	// Price is 10.4, Stock is 10
	// On sale price is 19.8, on sale amount is 2, Stock is 10
	private Item _underTest;

	@Test
	public void testConstructor1() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), 2);
	}

	@Test
	public void testConstructor2() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), new BigDecimal(2));
	}

	@Test
	public void testConstructor3() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), 2, TestUtils.aPriceOnSale(), 2);
	}

	@Test
	public void testConstructor4() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), new BigDecimal(2), TestUtils.aPriceOnSale(), new BigDecimal(2));
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorNameInvalid() throws InvalidAttributeValueException {
		new Item("", TestUtils.aPrice(), 2);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorNameNull() throws InvalidAttributeValueException {
		new Item(null, TestUtils.aPrice(), 2);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorOnSaleAmountInvalud() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), 2, TestUtils.aPriceOnSale(), 0);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorOnSaleAmountNull() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), new BigDecimal(2), TestUtils.aPriceOnSale(), (BigDecimal) null);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorOnSalePriceNull() throws InvalidAttributeValueException {
		new Item("Test Item Name", TestUtils.aPrice(), 2, null, 2);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testConstructorPriceNull() throws InvalidAttributeValueException {
		new Item("Test Item Name", null, 2);
	}

	@Test
	public void testSellItemFullUnit() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.anItem(true);

		// THEN
		assertEquals(10.4, _underTest.sellItem(1).doubleValue(), 0.0);
		assertEquals(9, _underTest.getStock().intValue());

		assertEquals(52, _underTest.sellItem(5).doubleValue(), 0.0);
		assertEquals(4, _underTest.getStock().intValue());
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testSellItemFullUnitInvalidAmount() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.anItem(true);

		// THEN
		assertEquals(10.4, _underTest.sellItem(1.1).doubleValue(), 0.0);
	}

	@Test
	public void testSellItemPartialUnit() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.anItem(false);

		// THEN
		assertEquals(15.6, _underTest.sellItem(1.5).doubleValue(), 0.0);
		assertEquals(8.5, _underTest.getStock().doubleValue(), 0.0);

		assertEquals(52, _underTest.sellItem(5).doubleValue(), 0.0);
		assertEquals(3.5, _underTest.getStock().doubleValue(), 0.0);
	}

	@Test
	public void testSellOnSaleItemFullUnit() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.anOnSaleItem(true);
		// On sale price is 19.8, on sale amount is 2, Stock is 10

		// THEN
		assertEquals(10.4, _underTest.sellItem(1).doubleValue(), 0.0);
		assertEquals(9, _underTest.getStock().intValue());

		assertEquals(19.8, _underTest.sellItem(2).doubleValue(), 0.0);
		assertEquals(7, _underTest.getStock().intValue());

		// 2 for 19.8 and 1 for 10.4
		assertEquals(30.2, _underTest.sellItem(3).doubleValue(), 0.0);
		assertEquals(4, _underTest.getStock().intValue());
	}

	@Test
	public void testSellOnSaleItemPartialUnit() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = TestUtils.anOnSaleItem(false);

		// THEN
		assertEquals(10.4, _underTest.sellItem(1).doubleValue(), 0.0);
		assertEquals(9, _underTest.getStock().doubleValue(), 0.0);

		assertEquals(15.6, _underTest.sellItem(1.5).doubleValue(), 0.0);
		assertEquals(7.5, _underTest.getStock().doubleValue(), 0.0);

		assertEquals(19.8, _underTest.sellItem(2).doubleValue(), 0.0);
		assertEquals(5.5, _underTest.getStock().doubleValue(), 0.0);

		assertEquals(25, _underTest.sellItem(2.5).doubleValue(), 0.0);
		assertEquals(3, _underTest.getStock().doubleValue(), 0.0);
	}

}
