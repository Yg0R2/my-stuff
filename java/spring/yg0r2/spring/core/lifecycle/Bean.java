/**
 * 
 */
package yg0r2.spring.core.lifecycle;

import yg0r2.spring.core.BaseBean;

/**
 * @author Yg0R2
 */
public class Bean extends BaseBean {

	public void initMethod() {
		System.out.println("Inside of 'initMethod()' method.");
	}

	public void destroyMethod() {
		System.out.println("Inside of 'destroyMethod()' method.");
	}

}
