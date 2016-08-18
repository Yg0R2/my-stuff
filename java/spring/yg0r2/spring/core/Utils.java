/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
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

	/**
	 * Use with the full path of the bean.xml file.
	 *
	 * @param springFile
	 * @return
	 */
	public static AbstractApplicationContext getApplicationContext(String springFile) {
		return new ClassPathXmlApplicationContext(springFile);
	}

}
