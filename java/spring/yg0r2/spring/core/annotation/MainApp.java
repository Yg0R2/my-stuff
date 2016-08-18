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
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

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
