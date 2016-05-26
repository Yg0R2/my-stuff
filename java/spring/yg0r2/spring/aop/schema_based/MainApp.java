/**
 * 
 */
package yg0r2.spring.aop.schema_based;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student bean = CONTEXT.getBean(Student.class, "student");

		bean.getName();
		bean.getAge();

		bean.printThrowException();
	}

}
