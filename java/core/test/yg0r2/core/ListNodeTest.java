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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import yg0r2.core.node.ListNode;
import yg0r2.core.node.Node;

/**
 * @author Yg0R2
 */
public class ListNodeTest {

	private Node<String> _underTest;

	@Test
	public void testNodeAdd() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("a");

		// WHEN
		assertEquals("a", _underTest.toString());
	}

	@Test
	public void testNodeAdd2() {
		// GIVEN in setUp

		// THEN
		Node<Integer> underTest = new ListNode<>();
		underTest.add(20);
		underTest.add(70);
		underTest.add(50);
		underTest.add(30);
		underTest.add(10);
		underTest.add(60);

		// WHEN
		assertEquals("207050301060", underTest.toString());
	}

	@Test
	public void testNodeAddDuplicated() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("a");
		_underTest.add("a");
		_underTest.add("b");
		_underTest.add("b");
		_underTest.add("c");

		// WHEN
		assertEquals("aabbc", _underTest.toString());
	}

	@Test
	public void testNodeAddDuplicatedAllowed() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("b");
		_underTest.add("a");
		_underTest.add("c");
		_underTest.add("a");
		_underTest.add("b");

		// WHEN
		assertEquals("bacab", _underTest.toString());
	}

	@Test
	public void testNodeAddDuplicatedAllowedSequential() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("a");
		_underTest.add("a");
		_underTest.add("b");
		_underTest.add("b");
		_underTest.add("c");

		// WHEN
		assertEquals("aabbc", _underTest.toString());
	}

	@Test
	public void testNodeAddInverseSequentialMultiple() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("c");
		_underTest.add("b");
		_underTest.add("a");

		// WHEN
		assertEquals("cba", _underTest.toString());
	}

	@Test
	public void testNodeAddMultiple() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("g");
		_underTest.add("e");
		_underTest.add("j");
		_underTest.add("p");
		_underTest.add("k");

		// WHEN
		assertEquals("gejpk", _underTest.toString());
	}

	@Test
	public void testNodeAddSequentialMultiple() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();
		_underTest.add("a");
		_underTest.add("b");
		_underTest.add("c");

		// WHEN
		assertEquals("abc", _underTest.toString());
	}

	@Test
	public void testNodeNull() {
		// GIVEN in setUp

		// THEN
		_underTest = new ListNode<>();

		// WHEN
		assertEquals("", _underTest.toString());
	}

}
