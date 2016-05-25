/**
 * 
 */
package yg0r2.spring.core.inner_bean;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_injecting_inner_beans.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextEditor textEditor = (TextEditor) CONTEXT.getBean("textEditor");

		textEditor.spellCheck();
	}

}
