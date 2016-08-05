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
package yg0r2.kata.transitive_dependencies;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * @author Yg0R2
 */
public class DependencyTest {

	private Map<Character, List<Character>> _dependencyMap;
	private Dependency _underTest;

	@Before
	public void setUp() {
		_dependencyMap = new HashMap<>();
		_dependencyMap.put('A', Arrays.asList('B'));
		_dependencyMap.put('B', Arrays.asList('C'));
		_dependencyMap.put('C', Arrays.asList('D'));
		_dependencyMap.put('D', Arrays.asList('E'));
		_dependencyMap.put('E', Arrays.asList('F'));
		_dependencyMap.put('F', Arrays.asList('G'));
		_dependencyMap.put('G', Arrays.asList('H'));
		_dependencyMap.put('H', new ArrayList<>(0));
	}

	@Test
	public void testGetDependencies() {
		// GIVEN in setUp

		// WHEN
		_underTest = new Dependency(_dependencyMap);

		// THEN
		assertEquals(null, _underTest.getDependencies('H'));
		assertEquals(Sets.newHashSet('H'), _underTest.getDependencies('G'));
		assertEquals(Sets.newHashSet('G', 'H'), _underTest.getDependencies('F'));
		assertEquals(Sets.newHashSet('F', 'G', 'H'), _underTest.getDependencies('E'));
		assertEquals(Sets.newHashSet('E', 'F', 'G', 'H'), _underTest.getDependencies('D'));
		assertEquals(Sets.newHashSet('D', 'E', 'F', 'G', 'H'), _underTest.getDependencies('C'));
		assertEquals(Sets.newHashSet('C', 'D', 'E', 'F', 'G', 'H'), _underTest.getDependencies('B'));
		assertEquals(Sets.newHashSet('B', 'C', 'D', 'E', 'F', 'G', 'H'), _underTest.getDependencies('A'));
	}

	@Test
	public void testGetDependenciesFronDummy() {
		// GIVEN
		_dependencyMap = Dependency.DUMMY_DEPENDENCY_MAP;

		// WHEN
		_underTest = new Dependency(_dependencyMap);

		// THEN
		assertEquals(Sets.newHashSet('B', 'C', 'E', 'F', 'G', 'H'), _underTest.getDependencies('A'));
		assertEquals(Sets.newHashSet('C', 'E', 'F', 'G', 'H'), _underTest.getDependencies('B'));
		assertEquals(Sets.newHashSet('G'), _underTest.getDependencies('C'));
		assertEquals(Sets.newHashSet('A', 'B', 'C', 'E', 'F', 'G', 'H'), _underTest.getDependencies('D'));
		assertEquals(Sets.newHashSet('F', 'H'), _underTest.getDependencies('E'));
		assertEquals(Sets.newHashSet('H'), _underTest.getDependencies('F'));
		assertEquals(null, _underTest.getDependencies('G'));
		assertEquals(null, _underTest.getDependencies('H'));
	}
}
