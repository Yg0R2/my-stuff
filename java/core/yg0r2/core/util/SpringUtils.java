/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yg0r2.core.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yg0R2
 */
public class SpringUtils {

	/**
	 * Use with default '<b>Bean.xml</b>' file with the given class' package.
	 *
	 * @param clazz search after the '<b>Bean.xml</b>' file next to this class' package.
	 * @return
	 */
	public static ApplicationContext getApplicationContext(Class<?> clazz) {
		return getApplicationContext(clazz, "Bean.xml");
	}

	/**
	 * Use with the full path of the bean.xml file.
	 *
	 * @param beanFile full path of the bean file.
	 * @return
	 */
	public static ApplicationContext getApplicationContext(String beanFile) {
		return new ClassPathXmlApplicationContext(beanFile);
	}

	/**
	 * Use with with the given class' package and with the given bean.xml file.
	 * 
	 * @param clazz search after the '<code>springFile</code>' file next to this class' package.
	 * @param beanFile name of the bean file.
	 * @return
	 */
	public static ApplicationContext getApplicationContext(Class<?> clazz, String beanFile) {
		String packageName = clazz.getPackage().getName();
		packageName = packageName.replace('.', '/');

		return getApplicationContext(packageName + "/" + beanFile);
	}

	/**
	 * Returns with a <code>returnType</code> type of bean from the given applicationContext.
	 *
	 * @param returnType return type of the bean.
	 * @param applicationContext get the requested <code>beanId</code> bean from this ApplicationContext.
	 * @param beanId the id of the requested bean.
	 * @return
	 */
	public static <T> T getBean(Class<T> returnType, ApplicationContext applicationContext, String beanId) {
		return applicationContext.getBean(returnType, beanId);
	}

	/**
	 * Returns with a <code>returnType</code> type of bean; It will search after the <code>beanId</code> in the
	 * <b>Bean.xml</b> file next to the given clazz's package.
	 *
	 * @param returnType return type of the bean.
	 * @param clazz search after the '<b>Bean.xml</b>' file next to this class' package.
	 * @param beanId the id of the requested bean.
	 * @return
	 */
	public static <T> T getBean(Class<T> returnType, Class<?> clazz, String beanId) {
		return getBean(returnType, getApplicationContext(clazz), beanId);
	}

	/**
	 * Returns with a <code>returnType</code> type of bean; It will search after the <code>beanId</code> in the given
	 * <code>binFile</code>.
	 *
	 * @param returnType return type of the bean.
	 * @param beanFile full path of the bean file.
	 * @param beanId the id of the requested bean.
	 * @return
	 */
	public static <T> T getBean(Class<T> returnType, String beanFile, String beanId) {
		return getBean(returnType, getApplicationContext(beanFile), beanId);
	}

	/**
	 * Returns with a <code>returnType</code> type of bean; It will search after the <code>beanId</code> in the given
	 * <code>binFile</code> file next to the given clazz's package.
	 *
	 * @param returnType return type of the bean.
	 * @param clazz search after the '<code>beanFile</code>' file next to this class' package.
	 * @param beanFile name of the bean file.
	 * @param beanId the id of the requested bean.
	 * @return
	 */
	public static <T> T getBean(Class<T> returnType, Class<?> clazz, String beanFile, String beanId) {
		return getBean(returnType, getApplicationContext(clazz, beanFile), beanId);
	}

}
