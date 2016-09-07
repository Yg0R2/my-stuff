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

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yg0R2
 */
public class PrimeFactorsJUnitTest {

	private PrimeFactors _underTesting;

	@Before
	public void setUp() {
		_underTesting = new PrimeFactors();
	}

	@Test
	public void oneHasNoPrimeFators() {
		assertEquals(asList(), _underTesting.getFactors(1));
	}

	@Test
	public void twoHasOneTimeTwoAsPrimeFactors() {
		assertEquals(asList(2), _underTesting.getFactors(2));
	}

	@Test
	public void threeHasOneTimeThreeAsPrimeFactors() {
		assertEquals(asList(3), _underTesting.getFactors(3));
	}

	@Test
	public void fourHasTwoTimesTwoAsPrimeFactors() {
		assertEquals(asList(2, 2), _underTesting.getFactors(4));
	}

	@Test
	public void fiveHasOneTimesFiveAsPrimeFactors() {
		assertEquals(asList(5), _underTesting.getFactors(5));
	}

	@Test
	public void sixHasOneTimeTwoAndOneTimeThreeAsPrimeFactors() {
		assertEquals(asList(2, 3), _underTesting.getFactors(6));
	}

	@Test
	public void sevenHasOneTimeSevenAsPrimeFactors() {
		assertEquals(asList(7), _underTesting.getFactors(7));
	}

	@Test
	public void eightHasThreeTimesTwoAsPrimeFactors() {
		assertEquals(asList(2, 2, 2), _underTesting.getFactors(8));
	}

	@Test
	public void nineHasTwoTimesThreeAsPrimeFactors() {
		assertEquals(asList(3, 3), _underTesting.getFactors(9));
	}

	@Test
	public void tenHasOneTimeTowAndOneTimeFiveAsPrimeFactors() {
		assertEquals(asList(2, 5), _underTesting.getFactors(10));
	}

}
