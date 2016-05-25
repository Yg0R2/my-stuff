/**
 * 
 */
package yg0r2.spring.core.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;

import yg0r2.spring.core.BaseBean;
import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_bean_life_cycle.htm
 */
public class MainApp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// Beans which extends (InitializingBean|DisposableBean)

		execute(InitInitializingBean.class, "init");
		execute(DestroyDisposableBean.class, "destroy");

		// Beans with (init|destroy)Method

		execute(InitMethodBean.class, "init");
		execute(DestroyMethodBean.class, "destroy");

		// Bean with init and destroy methods

		execute(Bean.class, "bean");
	}

	private static void execute(Class<? extends BaseBean> clazz, String beanId) {
		String clazzName = clazz.getSimpleName();

		// I have used the same name for the bean.xml as the class' name.
		String beanFileName = clazzName + ".xml";

		System.out.println(clazzName + ":");

		AbstractApplicationContext context = Utils.getApplicationContext(MainApp.class, beanFileName);

		BaseBean bean = (BaseBean) context.getBean(beanId);
		bean.getMessage();

		context.registerShutdownHook();
		context.close();

		System.out.println();
	}

}