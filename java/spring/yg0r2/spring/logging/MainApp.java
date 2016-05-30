/**
 * 
 */
package yg0r2.spring.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.BaseBean;
import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	private static Logger _logger = LoggerFactory.getLogger(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		_logger.info("Going to create HelloWord Obj");

		BaseBean bean = CONTEXT.getBean("bean", BaseBean.class);

		bean.getMessage();

		_logger.info("Exiting the program");
	}

}
