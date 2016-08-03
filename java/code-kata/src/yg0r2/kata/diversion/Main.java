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
package yg0r2.kata.diversion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata15-a-diversion/
 */
public class Main {

	private static final int _DIGIT = 3;
	private static final Logger _LOGGER = LoggerFactory.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Diversion diversion = new Diversion();

		List<Boolean[]> acceptedBits = diversion.getAcceptedBits(_DIGIT);

		for (Boolean[] bits : acceptedBits) {
			StringBuilder sb = new StringBuilder();

			for (Boolean bit : bits) {
				sb.append(bit ? '1' : '0');
			}

			_LOGGER.info(sb.toString());
		}
	}

}
