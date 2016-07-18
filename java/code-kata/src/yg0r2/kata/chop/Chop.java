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
package yg0r2.kata.chop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata02-karate-chop/
 */
public class Chop {

	public int search1(int searchNumber, List<Integer> list) {
		if (!list.isEmpty()) {
			int startIndex = 0;
			int endIndex = list.size();

			while (((startIndex + 1) < endIndex) || (list.get(startIndex) == searchNumber)) {
				int middleIndex = startIndex + (endIndex - startIndex) / 2;
				int middleValue = list.get(middleIndex);

				if (searchNumber == middleValue) {
					return middleIndex;
				}
				else if (searchNumber < middleValue) {
					endIndex = middleIndex;
				}
				else {
					startIndex = middleIndex;
				}
			}
		}

		return -1;
	}

	public int search2(int searchNumber, List<Integer> list) {
		if (list.isEmpty() || ((list.size() == 1) && (list.get(0) != searchNumber))) {
			return -1;
		}

		int middleIndex = list.size() / 2;
		int middleValue = list.get(middleIndex);

		if (searchNumber == middleValue) {
			return middleIndex;
		}
		else if (searchNumber < middleValue) {
			return search2(searchNumber, list.subList(0, middleIndex));
		}
		else {
			int resultIndex = search2(searchNumber, list.subList(middleIndex, list.size()));

			if (resultIndex == -1) {
				return -1;
			}

			return middleIndex + resultIndex;
		}
	}

	public int search3(int searchNumber, List<Integer> list) {
		Integer[] array = list.toArray(new Integer[list.size()]);

		int resultIndex = Arrays.binarySearch(array, searchNumber);

		if (resultIndex < 0) {
			return -1;
		}

		return resultIndex;
	}

	public int search4(int searchNumber, List<Integer> list) {
		int resultIndex = Collections.binarySearch(list, searchNumber);

		if (resultIndex < 0) {
			return -1;
		}

		return resultIndex;
	}

	/*public int search5(int searchNumber, List<Integer> list) {
		
	}*/

}
