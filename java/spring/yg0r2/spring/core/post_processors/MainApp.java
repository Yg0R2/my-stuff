/**
 * 
 */
package yg0r2.spring.core.post_processors;

import org.springframework.context.support.AbstractApplicationContext;

import yg0r2.spring.core.AdvancedBean;
import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_bean_post_processors.htm
 */
public class MainApp {

	private static final AbstractApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdvancedBean bean = (AdvancedBean) CONTEXT.getBean("bean");

		bean.getMessage();

		CONTEXT.registerShutdownHook();
	}

}
