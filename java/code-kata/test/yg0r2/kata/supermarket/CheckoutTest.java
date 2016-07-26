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
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yg0R2
 */
public class CheckoutTest {

	private List<Item> _items;
	private Checkout _underTest;

	@Before
	public void setUp() throws InvalidAttributeValueException {
		_items = new ArrayList<>();

		_items.add(new Item("A", new Price(50), 10, new Price(130), 3));
		_items.add(new Item("B", new Price(30), 10, new Price(45), 2));
		_items.add(new Item("C", new Price(20), 10));
		_items.add(new Item("D", new Price(15), 10));
	}

	@Test
	public void testSellItem() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Checkout(_items);
		_underTest.scan("A");

		// THEN
		assertEquals(50, _underTest.getTotal().doubleValue(), 0.0);
	}

	@Test
	public void testSellItems() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Checkout(_items);
		_underTest.scan("A");
		_underTest.scan("A");

		// THEN
		assertEquals(100, _underTest.getTotal().doubleValue(), 0.0);
	}

	@Test
	public void testSellMultipleItems() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Checkout(_items);
		_underTest.scan("A");
		_underTest.scan("B");
		_underTest.scan("C");
		_underTest.scan("D");

		// THEN
		assertEquals(115, _underTest.getTotal().doubleValue(), 0.0);
	}

	@Test
	public void testSellNothing() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Checkout(_items);
		_underTest.scan("");

		// THEN
		assertEquals(0, _underTest.getTotal().doubleValue(), 0.0);
	}

	@Test
	public void testSellOnSaleItem() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Checkout(_items);
		_underTest.scan("A");
		_underTest.scan("A");
		_underTest.scan("A");

		// THEN
		assertEquals(130, _underTest.getTotal().doubleValue(), 0.0);
	}

	@Test(expected = InvalidAttributeValueException.class)
	public void testSellTooManyItems() throws InvalidAttributeValueException {
		// GIVEN in setUp

		// WHEN
		_underTest = new Checkout(_items);
		_underTest.scan("A", 11);

		// THEN
		assertEquals(50, _underTest.getTotal().doubleValue(), 0.0);
	}

}
