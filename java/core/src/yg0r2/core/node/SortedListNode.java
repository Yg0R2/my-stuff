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
package yg0r2.core.node;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 *
 *         This class can work as a Linked List.
 */
public class SortedListNode<T extends Comparable<T>> extends Node<T> {

	/**
	 * Add a new value to the Node.
	 *
	 * @param value
	 */
	public void add(T value) {
		if (Validator.isNull(value)) {
			throw new RuntimeException("Value must not be null.");
		}

		// in case of the 1. node
		if (Validator.isNull(this.value)) {
			setValue(value);

			return;
		}

		if (value.compareTo(this.value) < 0) {
			if (left == null) {
				left = new SortedListNode<>();
				left.setRight(this);
			}

			left.add(value);

			return;
		}

		SortedListNode<T> newNode = new SortedListNode<>();
		newNode.setLeft(left);
		newNode.setRight(this);
		newNode.setValue(this.value);

		setLeft(newNode);
		setValue(value);

		left.setRight(newNode);
	}

	@Override
	public SortedListNode<T> clone() {
		SortedListNode<T> newNode = new SortedListNode<T>();
		newNode.setLeft(left);
		newNode.setRight(right);
		newNode.setValue(value);

		return newNode;
	}

}
