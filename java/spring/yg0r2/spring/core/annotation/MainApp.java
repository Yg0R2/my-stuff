/**
 * 
 */
package yg0r2.spring.core.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_annotation_based_configuration.htm
 * @see http://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		_configureWithConstructor();

		_configureWithSetter();

		_textEditor();
	}

	private static void _configureWithConstructor() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
			HelloWorldConfig.class);

		HelloWorld helloWorld = context.getBean(HelloWorld.class);

		helloWorld.setMessage("Hello first World!!");
		helloWorld.getMessage();

		context.close();

		System.out.println();
	}

	private static void _configureWithSetter() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(HelloWorldConfig.class);
		context.refresh();

		HelloWorld helloWorld = context.getBean(HelloWorld.class);

		helloWorld.setMessage("Hello second World!!");
		helloWorld.getMessage();

		context.close();

		System.out.println();
	}

	private static void _textEditor() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);

		TextEditor bean = context.getBean(TextEditor.class);

		bean.spellCheck();

		context.close();

		System.out.println();
	}
}
