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

import java.util.ArrayList;
import java.util.List;

import yg0r2.core.util.StringUtil;

/**
 * @author Yg0R2
 */
public class Anagram {

	private List<String> _anagrams;
	private long _hashKey;
	private String _key;

	public Anagram(String key) {
		_anagrams = new ArrayList<>(0);
		_hashKey = StringUtil.getHashCode(_key, false);
		_key = key;
	}

	public List<String> getAnagrams() {
		return _anagrams;
	}

	public String getWord() {
		return _key;
	}

	public long getHashCode() {
		return _hashKey;
	}

	public void putAnagram(String anagram) {
		_anagrams.add(anagram);
	}

	@Override
	public String toString() {
		return _key + ", " + _hashKey;
	}

}