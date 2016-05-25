/**
 * 
 */
package yg0r2.spring.core.collection;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_injecting_collection.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaCollectionBean bean = (JavaCollectionBean) CONTEXT.getBean("javaCollection");

		bean.getAddressList();
		bean.getAddressMap();
		bean.getAddressProp();
		bean.getAddressSet();
	}

}
