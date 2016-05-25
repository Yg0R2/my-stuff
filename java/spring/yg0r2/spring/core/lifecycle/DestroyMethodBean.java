/**
 * 
 */
package yg0r2.spring.core.lifecycle;

import yg0r2.spring.core.BaseBean;

/**
 * @author Yg0R2
 */
public class DestroyMethodBean extends BaseBean {

	public void destroyMethod() {
		System.out.println("Inside of 'destroyMethod()' method.");
	}

}
