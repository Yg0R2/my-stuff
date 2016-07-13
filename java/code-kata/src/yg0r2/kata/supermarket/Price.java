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

/**
 * @author Yg0R2
 */
public class Price {

	private BigDecimal _unitPrice;

	/**
	 * Constructor with:
	 *
	 * @param unitPrice The price of a unit.
	 * @throws InvalidAttributeValueException When the <code>unitPrice</code> is not bigger than 0.
	 */
	public Price(BigDecimal unitPrice) throws InvalidAttributeValueException {
		if (unitPrice.signum() <= 0) {
			throw new InvalidAttributeValueException("The value must be positive, and bigger than 0");
		}

		_unitPrice = unitPrice;
	}

	/**
	 * Constructor with:
	 *
	 * @param unitPrice The price of a unit.
	 * @throws InvalidAttributeValueException When the <code>unitPrice</code> is not bigger than 0.
	 */
	public Price(Double unitPrice) throws InvalidAttributeValueException {
		this(new BigDecimal(unitPrice));
	}

	/**
	 * Constructor with:
	 *
	 * @param unitPrice The price of a unit.
	 * @throws InvalidAttributeValueException When the <code>unitPrice</code> is not bigger than 0.
	 */
	public Price(Integer unitPrice) throws InvalidAttributeValueException {
		this(new BigDecimal(unitPrice));
	}

	/**
	 * @param amountPerUnitRate rate of the amount/unit (Unit usually 1)
	 * @return with the price of the <code>unitPerAmountRate</code>
	 */
	public BigDecimal getPrice(BigDecimal amount) {
		BigDecimal price = _unitPrice.multiply(amount);

		return price.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();
	}

	/**
	 * @param amountPerUnitRate rate of the amount/unit (Unit usually 1)
	 * @return with the price of the <code>unitPerAmountRate</code>
	 */
	public BigDecimal getPrice(Double amount) {
		return getPrice(new BigDecimal(amount));
	}

	/**
	 * @param amountPerUnitRate rate of the amount/unit (Unit usually 1)
	 * @return with the price of the <code>unitPerAmountRate</code>
	 */
	public BigDecimal getPrice(Integer amount) {
		return getPrice(new BigDecimal(amount));
	}

	/**
	 * @return with the price of 1 unit.
	 */
	public BigDecimal getPricePerUnit() {
		return _unitPrice;
	}

}
