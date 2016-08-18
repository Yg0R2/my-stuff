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
