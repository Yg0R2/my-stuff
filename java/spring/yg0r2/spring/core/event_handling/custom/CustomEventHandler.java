/**
 * 
 */
package yg0r2.spring.core.event_handling.custom;

import org.springframework.context.ApplicationListener;

/**
 * @author Yg0R2
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event.toString());
	}

}
