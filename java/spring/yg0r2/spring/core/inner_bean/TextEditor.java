/**
 * 
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
		System.out.println("Inside setSpellChecker." );

		_spellChecker = spellChecker;
	}

	public void spellCheck() {
		_spellChecker.checkSpelling();
	}

}
