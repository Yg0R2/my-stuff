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
package yg0r2.tmp;

import java.math.BigDecimal;

/**
 * @author Yg0R2
 */
public class BigDecimalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		doBigDecimal();
	}

	protected static void doBigDecimal() {
		BigDecimal bd = new BigDecimal(0);

		System.out.println(bd.compareTo(BigDecimal.ZERO));
		System.out.println(bd.signum());

		System.out.println("isInteger");
		System.out.println("0: " + (new BigDecimal(0).stripTrailingZeros().scale() <= 0));
		System.out.println("1.0: " + (new BigDecimal(1.0).stripTrailingZeros().scale() <= 0));
		System.out.println("1.10: " + (new BigDecimal(1.10).stripTrailingZeros().scale() <= 0));

		System.out.println("-----");
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(2);
		System.out.println(bd1.divide(bd2));
		System.out.println(bd1.divide(bd2).intValue() > 0);
	}

}
