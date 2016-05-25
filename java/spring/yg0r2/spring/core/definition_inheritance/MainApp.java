/**
 * 
 */
package yg0r2.spring.core.definition_inheritance;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_bean_definition_inheritance.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld helloWorldBean = (HelloWorld) CONTEXT.getBean("helloWorld");

		helloWorldBean.getMessage1();
		helloWorldBean.getMessage2();

		System.out.println();

		HelloIndia helloIndiaBean = (HelloIndia) CONTEXT.getBean("helloIndia");

		helloIndiaBean.getMessage1();
		helloIndiaBean.getMessage2();
		helloIndiaBean.getMessage3();
	}

}
