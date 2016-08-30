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

import yg0r2.core.node.Node;
import yg0r2.core.node.SortedListNode;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata11-sorting-it-out/
 */
public class CharSorting {

	public String sort(String s) {
		s = s.toLowerCase();
		s = s.replace(",", "");
		s = s.replace(".", "");
		s = s.replace(" ", "");

		Node<Character> node = new SortedListNode<>();

		s.chars().forEach(c -> node.add((char) c));

		return node.toString();
	}

}

