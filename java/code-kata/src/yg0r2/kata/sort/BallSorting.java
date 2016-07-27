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
package yg0r2.kata.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata11-sorting-it-out/
 */
public class BallSorting {

	private List<Integer> _list;

	public BallSorting() {
		_list = new ArrayList<>();
	}

	public void add(int item) {
		if (_list.isEmpty() || (_list.get(_list.size() - 1) < item)) {
			_list.add(item);

			return;
		}

		boolean itemAlreadyAdded = false;

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < _list.size(); i++) {
			int element = _list.get(i);

			if ((item < element) && !itemAlreadyAdded) {
				result.add(item);

				itemAlreadyAdded = true;
			}

			result.add(element);
		}

		_list = result;
	}

	@Override
	public String toString() {
		return "[" + _list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(", ")) + "]";
	}

}
