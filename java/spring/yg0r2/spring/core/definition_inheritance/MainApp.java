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
package yg0r2.spring.core.definition_inheritance;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_bean_definition_inheritance.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld helloWorldBean = (HelloWorld) CONTEXT.getBean("helloWorld");

		helloWorldBean.getMessage1();
		helloWorldBean.getMessage2();

		System.out.println();

		HelloIndia helloIndiaBean = (HelloIndia) CONTEXT.getBean("helloIndia");

		helloIndiaBean.getMessage1();
		helloIndiaBean.getMessage2();
		helloIndiaBean.getMessage3();
	}

}
