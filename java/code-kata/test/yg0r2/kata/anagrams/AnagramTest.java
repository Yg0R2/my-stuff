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
package yg0r2.kata.anagrams;

import static org.testng.Assert.*;

import org.junit.Test;

/**
 * @author Yg0R2
 */
public class AnagramTest {

	@Test
	public void testHashCode() {
		assertEquals(aHashCode(" a "), aHashCode("a  "));
		assertEquals(aHashCode(" a!"), aHashCode("!a "));
		assertEquals(aHashCode("word"), aHashCode("drow"));

		assertNotEquals(aHashCode("boxen"), aHashCode("opine"));
		assertNotEquals(aHashCode("antiestablishmentarianism"), aHashCode("polytetrafluoroethylene's"));
		assertNotEquals(aHashCode("coaster's"), aHashCode("greenmailer"));

		assertNotEquals(aHashCode("acquaintanceship's"), aHashCode("amicableness's"));
		assertNotEquals(aHashCode("acquaintanceship's"), aHashCode("expressionism's"));
		assertNotEquals(aHashCode("expressionism's"), aHashCode("amicableness's"));

		assertNotEquals(aHashCode("Britishnesses"), aHashCode("navigability"));
	}

	protected long aHashCode(String key) {
		return new Anagram(key).getHashCode();
	}

}
