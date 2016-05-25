/**
 * 
 */
package yg0r2.spring.core.helloworld;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_hello_world_example.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld bean = (HelloWorld) CONTEXT.getBean("helloWorld");

		bean.getMessage();
	}

}
