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
package yg0r2.core;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 *
 *         This class can work as a Linked List.
 */
public class Node<T extends Comparable<T>> {

	private boolean _ignoreSameValue;
	private Node<T> _left;
	private Node<T> _right;
	private T _value;

	/**
	 * Constructor, the instance will ignore the same values in the list.
	 */
	public Node() {
		this(true);
	}

	/**
	 * Constructor
	 *
	 * @param ignoreSameValue If <b>true</b>, will ignore the same values in the list; if <b>false</b> the list can
	 *            contains multiple element with the same value.
	 */
	public Node(boolean ignoreSameValue) {
		_ignoreSameValue = ignoreSameValue;
	}

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
		if (Validator.isNull(_value)) {
			setValue(value);

			return;
		}

		if (_ignoreSameValue && _value.equals(value)) {
			return;
		}

		if (value.compareTo(_value) < 0) {
			if (_left == null) {
				_left = new Node<>(_ignoreSameValue);
				_left.setRight(this);
			}

			_left.add(value);

			return;
		}

		Node<T> newNode = new Node<>(_ignoreSameValue);
		newNode.setLeft(_left);
		newNode.setRight(this);
		newNode.setValue(_value);

		setLeft(newNode);
		setValue(value);

		_left.setRight(newNode);
	}

	@Override
	public Node<T> clone() {
		Node<T> newNode = new Node<T>(_ignoreSameValue);
		newNode.setLeft(_left);
		newNode.setRight(_right);
		newNode.setValue(_value);

		return newNode;
	}

	/**
	 * @return With the Left Node, which value is less than the value of the current Node.
	 */
	public Node<T> getLeft() {
		return _left;
	}

	/**
	 * @return With the right Node, which value is grater than the value of the current Node.
	 */
	public Node<T> getRight() {
		return _right;
	}

	/**
	 * @return With the value of this Node.
	 */
	public T getValue() {
		return _value;
	}

	/**
	 * Return a string value of the whole Node list.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(3);

		if (_left != null) {
			sb.append(_left.toString());
		}

		if (_value == null) {
			return "";
		}

		sb.append(String.valueOf(_value));

		return sb.toString();
	}

	/**
	 * Set the left Node.
	 *
	 * @param left
	 */
	protected void setLeft(Node<T> left) {
		_left = left;
	}

	/**
	 * Set the right Node.
	 *
	 * @param right
	 */
	protected void setRight(Node<T> right) {
		_right = right;
	}

	/**
	 * Set the value of this Node.
	 *
	 * @param value
	 */
	protected void setValue(T value) {
		_value = value;
	}

}
