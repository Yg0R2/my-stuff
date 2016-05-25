/**
 * 
 */
package yg0r2.spring.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;

import yg0r2.spring.core.BaseBean;

/**
 * @author Yg0R2
 */
public class DestroyDisposableBean extends BaseBean implements DisposableBean {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("Inside of 'destroy()' method.");
	}

}
