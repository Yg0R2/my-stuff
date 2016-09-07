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
package yg0r2.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 * @see http://www.codekatas.org/casts/prime-factors-code-kata-by-lets-developer
 */
public class PrimeFactors {

	public List<Integer> getFactors(int n) {
		List<Integer> result = new ArrayList<>();

		for (int candidate = 2; n > 1; candidate++) {
		//for (int candidate = 2; candidate <= n; candidate++) {
			for (; n % candidate == 0; n /= candidate) {
				result.add(candidate);
			}
		}

		return result;
	}

}
