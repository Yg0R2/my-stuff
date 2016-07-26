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
import java.math.RoundingMode;

import javax.naming.directory.InvalidAttributeValueException;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class Item {

	private String _name;
	private BigDecimal _onSaleAmount;
	private Price _onSalePrice;
	private Price _price;
	private boolean _sellOnlyFullUnit;
	private BigDecimal _stockAmount;

	public Item(String name, Price price, BigDecimal stockAmount) throws InvalidAttributeValueException {
		this(name, price, stockAmount, null, null);
	}

	public Item(String name, Price price, BigDecimal stockAmount, Price onSalePrice, BigDecimal onSaleAmount)
		throws InvalidAttributeValueException {

		if (Validator.isNull(name)) {
			throw new InvalidAttributeValueException("Name of the item must not be null.");
		}

		_name = name;

		if (Validator.isNull(price)) {
			throw new InvalidAttributeValueException("Price of the item must not be null.");
		}

		_price = price;

		if (Validator.isNull(stockAmount)) {
			throw new InvalidAttributeValueException("Stock of the item must not be null.");
		}
		else if (stockAmount.signum() <= 0) {
			throw new InvalidAttributeValueException("Stock of the item must be bigger than 0.");
		}
		else if (_sellOnlyFullUnit && !_isInteger(stockAmount)) {
			throw new InvalidAttributeValueException("Stock amount must be an integer.");
		}

		_stockAmount = stockAmount;

		if (onSalePrice != null) {
			if (Validator.isNull(onSaleAmount)) {
				throw new InvalidAttributeValueException(
					"Stock amount of the item must not be null, when on sale price is set");
			}
			else if (onSaleAmount.signum() <= 0) {
				throw new InvalidAttributeValueException(
					"Stock amount of the item must be bigger than 0, when on sale price is set");
			}
		}

		if (onSaleAmount != null) {
			if (Validator.isNull(onSalePrice)) {
				throw new InvalidAttributeValueException(
					"On sale price of the item must not be null, when stock amount is set");
			}
			else if (onSalePrice.getPricePerUnit().signum() <= 0) {
				throw new InvalidAttributeValueException(
					"On sale price of the item must be bigger than 0, when on stock amount is set");
			}
			else if (price.getPrice(onSaleAmount).compareTo(onSalePrice.getPricePerUnit()) < 0) {
				throw new InvalidAttributeValueException("aha");
			}
			else if (_sellOnlyFullUnit && !_isInteger(onSaleAmount)) {
				throw new InvalidAttributeValueException("On sale amount must be an integer.");
			}
		}

		_onSalePrice = onSalePrice;
		_onSaleAmount = onSaleAmount;
	}

	public Item(String name, Price price, Integer stockAmount) throws InvalidAttributeValueException {
		this(name, price, new BigDecimal(stockAmount));

		_sellOnlyFullUnit = true;
	}

	public Item(String name, Price price, Integer stockAmount, Price onSalePrice, Integer onSaleAmount)
		throws InvalidAttributeValueException {

		this(name, price, new BigDecimal(stockAmount), onSalePrice, new BigDecimal(onSaleAmount));

		_sellOnlyFullUnit = true;
	}

	public String getName() {
		return _name;
	}

	public BigDecimal getStock() {
		return _stockAmount;
	}

	public BigDecimal getUnitPrice() {
		return _price.getPricePerUnit();
	}

	public BigDecimal sellItem(BigDecimal amount) throws InvalidAttributeValueException {
		// Amount is grater than _stockAmount
		if (_stockAmount.compareTo(amount) == -1) {
			throw new InvalidAttributeValueException("There is not enough '" + _name + "' in stock.");
		}

		if (_sellOnlyFullUnit && !_isInteger(amount)) {
			throw new InvalidAttributeValueException("This '" + _name + "' can be sell only in one peace.");
		}

		_stockAmount = _stockAmount.subtract(amount);

		BigDecimal price = new BigDecimal(0);

		if (Validator.isNotNull(_onSaleAmount)) {
			// Count the onSale part
			int amountPerSaleAmount = amount.intValue() / _onSaleAmount.intValue();

			if (_isOnSaleItem() && amountPerSaleAmount > 0) {
				// Count the remaining part
				BigDecimal onSalePart = new BigDecimal(amountPerSaleAmount);

				// Set the amount to the other part if there is more than the the on sale
				amount = amount.subtract(_onSaleAmount.multiply(onSalePart));

				price = price.add(_onSalePrice.getPrice(onSalePart));
			}
		}

		price = price.add(_price.getPrice(amount));

		// Round up to 2 digits
		return price.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();
	}

	public BigDecimal sellItem(Double amount) throws InvalidAttributeValueException {
		return sellItem(new BigDecimal(amount));
	}

	public BigDecimal sellItem(Integer amount) throws InvalidAttributeValueException {
		return sellItem(new BigDecimal(amount));
	}

	private boolean _isInteger(BigDecimal checkValue) {
		return checkValue.stripTrailingZeros().scale() <= 0;
	}

	private boolean _isOnSaleItem() {
		return (_onSaleAmount != null) && (_onSalePrice != null);
	}

}
