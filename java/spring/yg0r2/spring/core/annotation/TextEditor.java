/**
 * 
 */
package yg0r2.spring.core.annotation;

/**
 * @author Yg0R2
 */
public class TextEditor {

	private SpellChecker _spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor." );

		_spellChecker = spellChecker;
	}

	public void spellCheck() {
		_spellChecker.checkSpelling();
	}

}
