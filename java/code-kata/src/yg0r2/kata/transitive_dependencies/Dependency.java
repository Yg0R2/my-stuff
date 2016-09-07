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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata18-transitive-dependencies/
 */
public class Dependency {

	public static final Map<Character, List<Character>> DUMMY_DEPENDENCY_MAP = new HashMap<>(7);

	static {
		DUMMY_DEPENDENCY_MAP.put('A', Arrays.asList('B', 'C'));
		DUMMY_DEPENDENCY_MAP.put('B', Arrays.asList('C', 'E'));
		DUMMY_DEPENDENCY_MAP.put('C', Arrays.asList('G'));
		DUMMY_DEPENDENCY_MAP.put('D', Arrays.asList('A', 'F'));
		DUMMY_DEPENDENCY_MAP.put('E', Arrays.asList('F'));
		DUMMY_DEPENDENCY_MAP.put('F', Arrays.asList('H'));
		DUMMY_DEPENDENCY_MAP.put('H', new ArrayList<>(0));
	}

	private Map<Character, List<Character>> _dependencyMap;

	public Dependency(Map<Character, List<Character>> dependenciesMap) {
		_dependencyMap = dependenciesMap;
	}

	public SortedSet<Character> getDependencies(char c) {
		c = Character.toUpperCase(c);

		List<Character> dependencies = _dependencyMap.get(c);

		if ((dependencies == null) || dependencies.isEmpty()) {
			return null;
		}

		SortedSet<Character> set = new TreeSet<>();

		for (Character ch : _dependencyMap.get(c)) {
			SortedSet<Character> dependent = getDependencies(ch);

			if (dependent != null) {
				set.addAll(dependent);
			}

			set.add((char) ch);
		}

		return set;
	}

}