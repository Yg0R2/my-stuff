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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

/**
 * @author Yg0R2
 */
public class TestUtils {

	public static List<Item> aListOfItems() {
		List<Item> items = new ArrayList<>();

		try {
			items.add(new Item("Test Item1 Name", aPrice(), 10));
			items.add(new Item("Test Item2 Name", aPrice(), new BigDecimal(10)));
		}
		catch (InvalidAttributeValueException e) {
			// Ignore
		}

		return items;
	}

	public static List<Item> aListOfOnSaleItems() {
		List<Item> items = new ArrayList<>();

		try {
			items.add(new Item("Test Item1 Name", aPrice(), 10, aPriceOnSale(), 2));
			items.add(new Item("Test Item2 Name", aPrice(), new BigDecimal(10), aPriceOnSale(), new BigDecimal(2)));
		}
		catch (InvalidAttributeValueException e) {
			// Ignore
		}

		return items;
	}

	public static Item anItem(boolean sellOnlyFullUnit) {
		try {
			if (sellOnlyFullUnit) {
				return new Item("Test Item Name", aPrice(), 10);
			}

			return new Item("Test Item Name", aPrice(), new BigDecimal(10));
		}
		catch (InvalidAttributeValueException e) {
			// Ignore
		}

		return null;
	}

	public static Item anOnSaleItem(boolean sellOnlyFullUnit) {
		try {
			if (sellOnlyFullUnit) {
				return new Item("Test Item Name", aPrice(), 10, aPriceOnSale(), 2);
			}

			return new Item("Test Item Name", aPrice(), new BigDecimal(10), aPriceOnSale(), new BigDecimal(2));
		}
		catch (InvalidAttributeValueException e) {
			// Ignore
		}

		return null;
	}

	public static Price aPrice() {
		try {
			return new Price(10.4);
		}
		catch (InvalidAttributeValueException e) {
			// Ignore
		}

		return null;
	}

	public static Price aPriceOnSale() {
		try {
			return new Price(19.8);
		}
		catch (InvalidAttributeValueException e) {
			// Ignore
		}

		return null;
	}

}
