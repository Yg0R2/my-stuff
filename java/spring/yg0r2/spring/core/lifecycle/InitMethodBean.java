/**
 * 
 */
package yg0r2.spring.core.lifecycle;

import yg0r2.spring.core.BaseBean;

/**
 * @author Yg0R2
 */
public class InitMethodBean extends BaseBean {

	public void initMethod() {
		System.out.println("Inside of 'initMethod()' method.");
	}

}
