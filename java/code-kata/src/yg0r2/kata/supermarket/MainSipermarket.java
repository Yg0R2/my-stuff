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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata01-supermarket-pricing/
 */
public class MainSipermarket {

	private static final Logger _logger = LoggerFactory.getLogger(MainSipermarket.class);

	private static Random _rnd = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<String> productNames = new ArrayList<>();

		List<Item> items = new ArrayList<>();

		productNames.add("apple");
		items.add(new Item("apple", new Price(2.1), 10));

		productNames.add("banana");
		items.add(new Item("banana", new Price(1.2), 30));

		productNames.add("pineapple");
		items.add(new Item("pineapple", new Price(5.1), 15, new Price(9), 2));

		productNames.add("beer");
		items.add(new Item("beer", new Price(2.2), 50, new Price(10), 5));

		Supermarket supermarket = new Supermarket(items, 500);

		for (int i = 0; i < 30; i++) {
			String itemName = productNames.get(_rnd.nextInt(productNames.size()));

			int count = _rnd.nextInt(10) + 1;

			if (supermarket.hasItem(itemName)) {
				_logger.info("Selling " + count + " of " + itemName);

				supermarket.sellItem(itemName, count);
			}
		}
	}

}
