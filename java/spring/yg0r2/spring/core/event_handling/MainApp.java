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
package yg0r2.spring.core.event_handling;

import org.springframework.context.ConfigurableApplicationContext;

import yg0r2.spring.core.BaseBean;
import yg0r2.spring.core.Utils;
import yg0r2.spring.core.event_handling.custom.CustomEventPublisher;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/event_handling_in_spring.htm
 * @see http://www.tutorialspoint.com/spring/custom_events_in_spring.htm
 */
public class MainApp {

	private static final ConfigurableApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		_eventHandling();

		_customEventHandling();
	}

	private static void _customEventHandling() {
		CustomEventPublisher bean = (CustomEventPublisher) CONTEXT.getBean("customEventPublisher");

		bean.publish();
		bean.publish();

		System.out.println();
	}

	private static void _eventHandling() {
		CONTEXT.start();

		BaseBean bean = (BaseBean) CONTEXT.getBean("helloWorld");

		bean.getMessage();

		CONTEXT.stop();

		System.out.println();
	}

}
