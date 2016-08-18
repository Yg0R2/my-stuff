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
package yg0r2.spring.core.inner_bean;

/**
 * @author Yg0R2
 */
public class TextEditor {

	private SpellChecker _spellChecker;

	/**
	 * @return the _spellChecker
	 */
	public SpellChecker getSpellChecker() {
		return _spellChecker;
	}

	/**
	 * @param spellChecker the spellChecker to set
	 */
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker.");

		_spellChecker = spellChecker;
	}

	public void spellCheck() {
		_spellChecker.checkSpelling();
	}

}
