/**
 * 
 */
package yg0r2.spring.core;

/**
 * @author Yg0R2
 */
public class AdvancedBean extends BaseBean {

	/**
	 * Used for destroying a bean. Call this method in bean with <b>destroy-method</b> tag.
	 */
	public void destroy() {
		System.out.println("Bean will destroyed now.");
	}

	/**
	 * Used for initializing a bean. Call this method in bean with <b>init-method</b> tag.
	 */
	public void init() {
		System.out.println("Bean is going through init.");
	}

}
