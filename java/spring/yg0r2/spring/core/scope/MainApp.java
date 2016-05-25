/**
 * 
 */
package yg0r2.spring.core.scope;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.BaseBean;
import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_bean_scopes.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BaseBean singletonBean1 = (BaseBean) CONTEXT.getBean("singleton");

		System.out.println("Singleton instance 1:");
		singletonBean1.getMessage();
		singletonBean1.setMessage("Singleton bean new message.");
		singletonBean1.getMessage();

		BaseBean singletonBean2 = (BaseBean) CONTEXT.getBean("singleton");

		System.out.println();
		System.out.println("Singleton instance 2:");
		singletonBean2.getMessage();

		BaseBean prototypeBean1 = (BaseBean) CONTEXT.getBean("prototype");

		System.out.println();
		System.out.println("Prototype instance 1:");
		prototypeBean1.getMessage();
		prototypeBean1.setMessage("Prototype bean new message.");
		prototypeBean1.getMessage();

		BaseBean prototypeBean2 = (BaseBean) CONTEXT.getBean("prototype");

		System.out.println();
		System.out.println("Prototype instance 2:");
		prototypeBean2.getMessage();
	}

}
