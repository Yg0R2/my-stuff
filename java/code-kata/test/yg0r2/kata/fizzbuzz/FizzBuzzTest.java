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
package yg0r2.kata.fizzbuzz;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Yg0R2
 */
public class FizzBuzzTest {

	private FizzBuzz _underTest;

	@DataProvider(name = "testGoodValues")
	public static Iterator<Object[]> testGoodValues() {
		List<Object[]> testValues = new ArrayList<>();

		testValues.add(new Object[] { 1, "1" });
		testValues.add(new Object[] { 2, "2" });
		testValues.add(new Object[] { 3, "Fizz" });
		testValues.add(new Object[] { 4, "4" });
		testValues.add(new Object[] { 5, "Buzz" });
		testValues.add(new Object[] { 6, "Fizz" });
		testValues.add(new Object[] { 7, "7" });
		testValues.add(new Object[] { 8, "8" });
		testValues.add(new Object[] { 9, "Fizz" });
		testValues.add(new Object[] { 10, "Buzz" });
		testValues.add(new Object[] { 11, "11" });
		testValues.add(new Object[] { 12, "Fizz" });
		testValues.add(new Object[] { 13, "13" });
		testValues.add(new Object[] { 14, "14" });
		testValues.add(new Object[] { 15, "FizzBuzz" });

		return testValues.iterator();
	}

	@DataProvider(name = "testBadValues")
	public static Iterator<Object[]> testBadValues() {
		List<Object[]> testValues = new ArrayList<>();

		testValues.add(new Object[] { 0 });
		testValues.add(new Object[] { -1 });

		return testValues.iterator();
	}

	@BeforeMethod
	public void setUp() {
		_underTest = new FizzBuzz();
	}

	@Test(dataProvider = "testBadValues", expectedExceptions = {IllegalArgumentException.class})
	public void testBadValue(int n) {
		_underTest.getAnswerFor(n);
	}

	@Test(dataProvider = "testGoodValues")
	public void testGoodValue(int n, String expected) {
		assertEquals(expected, _underTest.getAnswerFor(n));
	}

}
