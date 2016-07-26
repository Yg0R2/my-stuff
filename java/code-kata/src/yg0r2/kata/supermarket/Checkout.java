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

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class Checkout {

	private Map<String, BigDecimal> _boughtItems;
	private Map<String, Item> _itemsInStock;

	public Checkout(List<Item> itemsInStock) {
		_boughtItems = new HashMap<>();
		_itemsInStock = new HashMap<>();

		itemsInStock.forEach(item -> _itemsInStock.put(item.getName(), item));
	}

	public BigDecimal getTotal() throws InvalidAttributeValueException {
		BigDecimal result = new BigDecimal(0);

		for (Map.Entry<String, BigDecimal> entry : _boughtItems.entrySet()) {
			if (Validator.isNull(entry.getKey()) || Validator.isNull(entry.getValue())) {
				continue;
			}

			Item item = _itemsInStock.get(entry.getKey());

			result = result.add(item.sellItem(entry.getValue()));
		}

		return result;
	}

	public void scan(String itemName) {
		scan(itemName, new BigDecimal(1));
	}

	public void scan(String itemName, BigDecimal amount) {
		if (_boughtItems.containsKey(itemName)) {
			amount = amount.add(_boughtItems.get(itemName));
		}

		_boughtItems.put(itemName, amount);
	}

	public void scan(String itemName, Integer amount) {
		scan(itemName, new BigDecimal(amount));
	}

}
