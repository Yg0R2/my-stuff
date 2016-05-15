/**
 * 
 */
package yg0r2.designpattern.businessdelegate;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/business_delegate_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();

		businessDelegate.setServiceType("EJB");

		Client client = new Client(businessDelegate);

		client.doTask();

		businessDelegate.setServiceType("JMS");

		client.doTask();
	}

}