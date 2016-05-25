/**
 * 
 */
package yg0r2.spring.core.lifecycle;

import org.springframework.beans.factory.InitializingBean;

import yg0r2.spring.core.BaseBean;

/**
 * @author Yg0R2
 */
public class InitInitializingBean extends BaseBean implements InitializingBean {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside of 'afterPropertiesSet()' method.");
	}

}
