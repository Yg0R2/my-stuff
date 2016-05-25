/**
 * 
 */
package yg0r2.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yg0R2
 */
public class Utils {

	/**
	 * Use with default '<b>Bean.xml</b>' file with the given class' package.
	 *
	 * @param clazz
	 * @return
	 */
	public static AbstractApplicationContext getApplicationContext(Class<?> clazz) {
		return getApplicationContext(clazz, "Bean.xml");
	}

	/**
	 * Use with the full path of the bean.xml file.
	 *
	 * @param springFile
	 * @return
	 */
	public static AbstractApplicationContext getApplicationContext(String springFile) {
		return new ClassPathXmlApplicationContext(springFile);
	}

	/**
	 * Use with with the given class' package and with the given bean.xml file.
	 * 
	 * @param clazz
	 * @param springFile
	 * @return
	 */
	public static AbstractApplicationContext getApplicationContext(Class<?> clazz, String springFile) {
		String packageName = clazz.getPackage().getName();
		packageName = packageName.replace('.', '/');

		return getApplicationContext(packageName + "/" + springFile);
	}

}