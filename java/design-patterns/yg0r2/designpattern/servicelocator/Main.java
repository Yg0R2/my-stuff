/**
 * 
 */
package yg0r2.designpattern.servicelocator;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/service_locator_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Service service = ServiceLocator.getService("SERVICE1");

		service.execute();

		service = ServiceLocator.getService("SERVICE2");

		service.execute();

		service = ServiceLocator.getService("SERVICE1");

		service.execute();

		service = ServiceLocator.getService("SERVICE2");

		service.execute();
	}

}