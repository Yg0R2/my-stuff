/**
 * 
 */
package yg0r2.spring.core.event_handling.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author Yg0R2
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher _publisher;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher)
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		_publisher = publisher;
	}

	public void publish() {
		CustomEvent customEvent = new CustomEvent(this);

		_publisher.publishEvent(customEvent);
	}

}
