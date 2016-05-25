/**
 * 
 */
package yg0r2.spring.core.event_handling.custom;

import org.springframework.context.ApplicationEvent;

/**
 * @author Yg0R2
 */
@SuppressWarnings("serial")
public class CustomEvent extends ApplicationEvent {

	public CustomEvent(Object source) {
		super(source);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "My Custom Event";
	}

}
