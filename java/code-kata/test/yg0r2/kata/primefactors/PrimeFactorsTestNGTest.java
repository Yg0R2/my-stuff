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

import static java.util.Arrays.asList;
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
public class PrimeFactorsTestNGTest {

	private PrimeFactors _underTesting;

	@DataProvider(name = "numbers")
	public static Iterator<Object[]> numbers() {
		List<Object[]> numbers = new ArrayList<>();
		numbers.add(new Object[] { 1, asList() });
		numbers.add(new Object[] { 2, asList(2) });
		numbers.add(new Object[] { 3, asList(3) });
		numbers.add(new Object[] { 4, asList(2, 2) });
		numbers.add(new Object[] { 5, asList(5) });
		numbers.add(new Object[] { 6, asList(2, 3) });
		numbers.add(new Object[] { 7, asList(7) });
		numbers.add(new Object[] { 8, asList(2, 2, 2) });
		numbers.add(new Object[] { 9, asList(3, 3) });
		numbers.add(new Object[] { 10, asList(2, 5) });

		numbers.add(new Object[] { 173, asList(173) });

		numbers.add(new Object[] { 256, asList(2, 2, 2, 2, 2, 2, 2, 2) });

		return numbers.iterator();
	}

	@BeforeMethod
	public void setUp() {
		_underTesting = new PrimeFactors();
	}

	@Test(dataProvider = "numbers")
	public void asPrime(int n, List<Integer> expedted) {
		assertEquals(expedted, _underTesting.getFactors(n));
	}

}
