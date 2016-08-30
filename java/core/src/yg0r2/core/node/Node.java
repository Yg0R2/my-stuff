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

/**
 * @author Yg0R2
 *
 *         This class can work as a Linked List.
 */
public abstract class Node<T extends Comparable<T>> {

	protected Node<T> left;
	protected Node<T> right;
	protected T value;

	/**
	 * Add a new value to the Node.
	 *
	 * @param value
	 */
	public abstract void add(T value);

	/**
	 * Clone the current Node instance.
	 *
	 * @return Wit a cloned Node instance.
	 */
	public abstract Node<T> clone();

	/**
	 * @return With the Left Node, which value is less than the value of the current Node.
	 */
	public Node<T> getLeft() {
		return left;
	}

	/**
	 * @return With the right Node, which value is grater than the value of the current Node.
	 */
	public Node<T> getRight() {
		return right;
	}

	/**
	 * @return With the value of this Node.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Return a string value of the whole Node list.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(3);

		if (left != null) {
			sb.append(left.toString());
		}

		if (value == null) {
			return "";
		}

		sb.append(String.valueOf(value));

		return sb.toString();
	}

	/**
	 * Set the left Node.
	 *
	 * @param left
	 */
	protected void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * Set the right Node.
	 *
	 * @param right
	 */
	protected void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 * Set the value of this Node.
	 *
	 * @param value
	 */
	protected void setValue(T value) {
		this.value = value;
	}

}
