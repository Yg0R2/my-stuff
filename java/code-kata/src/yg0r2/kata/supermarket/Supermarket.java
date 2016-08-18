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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.InvalidAttributeValueException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 */
public class Supermarket {

	private static final Logger _logger = LoggerFactory.getLogger(Supermarket.class);

	private BigDecimal _budget;
	private Map<String, Item> _itemsMap = new HashMap<>();

	public Supermarket(List<Item> items, BigDecimal budget) throws InvalidAttributeValueException {
		if (items.isEmpty()) {
			throw new InvalidAttributeValueException("Yo cannot start a business without any item.");
		}

		items.forEach(item -> {
			_itemsMap.put(item.getName(), item);
		});

		if (budget.signum() <= 0) {
			throw new InvalidAttributeValueException("You cannot start a business with negative budget.");
		}

		_budget = budget;
	}

	public Supermarket(List<Item> items, Double budget) throws InvalidAttributeValueException {
		this(items, new BigDecimal(budget));
	}

	public Supermarket(List<Item> items, Integer budget) throws InvalidAttributeValueException {
		this(items, new BigDecimal(budget));
	}

	public BigDecimal getBudget() {
		return _budget;
	}

	public BigDecimal getStock(String itemName) {
		Item item = _itemsMap.get(itemName);

		return item.getStock();
	}

	public boolean hasItem(String itemName) {
		return _itemsMap.containsKey(itemName);
	}

	public void sellItem(String itemName, int count) {
		Item item = _itemsMap.get(itemName);

		BigDecimal itemsPrice = new BigDecimal(0);
		try {
			itemsPrice = item.sellItem(count);
		}
		catch (InvalidAttributeValueException e) {
			_logger.error(e.getMessage(), e);

			return;
		}
		catch (NullPointerException e) {
			_logger.debug("The '" + itemName + "' item is not available.");

			return;
		}

		_budget = _budget.add(itemsPrice);

		_logger.info("Items sold for: " + itemsPrice + "; The new balance is: " + _budget);

		if (item.getStock().doubleValue() == 0.0) {
			_itemsMap.remove(itemName);

			_logger.info("Item '" + itemName + "' has been sold out.");
		}

	}

}
