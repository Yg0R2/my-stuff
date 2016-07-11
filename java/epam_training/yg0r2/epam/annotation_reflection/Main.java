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
package yg0r2.epam.annotation_reflection;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import yg0r2.epam.annotation_reflection.annotations.Init;
import yg0r2.epam.annotation_reflection.annotations.Service;
import yg0r2.epam.annotation_reflection.annotations.classes.LazyService;
import yg0r2.epam.annotation_reflection.annotations.classes.SimpleService;
import yg0r2.epam.annotation_reflection.annotations.classes.ThrowingService;

/**
 * @author Yg0R2
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("-----------inspectService------------");

		inspectService(SimpleService.class);
		inspectService(LazyService.class);
		inspectService(ThrowingService.class);

		System.out.println("-----------printDeclaredMethodNames------------");

		printDeclaredMethodNames(SimpleService.class);
		printDeclaredMethodNames(LazyService.class);
		printDeclaredMethodNames(ThrowingService.class);

		System.out.println("-----------loadService------------");

		loadService(SimpleService.class);
		loadService(LazyService.class);
		loadService(ThrowingService.class);

		System.out.println("-----------------------");

		// invoke(SimpleService.class);
		// invoke(LazyService.class);
		invoke(ThrowingService.class);
		invoke(ThrowingService.class);
	}

	protected static void inspectService(Class<?> clazz) {
		if (clazz.isAnnotationPresent(Service.class)) {
			Service annotation = clazz.getAnnotation(Service.class);

			System.out.println("Name of annotation: " + annotation.name());
		}
	}

	protected static void invoke(Class<?> clazz) throws Exception {
		Object serviceObj = clazz.newInstance();

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {
			if (method.isAnnotationPresent(Init.class)) {
				try {
					method.invoke(serviceObj);
				}
				catch (Exception e) {
					Init annotation = method.getAnnotation(Init.class);

					if (annotation.suppressException()) {
						System.err.println(e);
					}
					else {
						throw new RuntimeException(e);
					}
				}
			}
		}
	}

	protected static void loadService(Class<?> clazz) throws Exception {
		Map<String, Object> serviceMap = new HashMap<String, Object>();

		if (clazz.isAnnotationPresent(Service.class)) {
			Service annotation = clazz.getAnnotation(Service.class);

			serviceMap.put(annotation.name(), clazz.newInstance());
		}

		serviceMap.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
	}

	protected static void printDeclaredMethodNames(Class<?> clazz) {
		for (Method method : clazz.getDeclaredMethods()) {
			System.out.println(method.getName());
		}
	}

}
