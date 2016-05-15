/**
 * 
 */
package yg0r2.designpattern.businessdelegate;

/**
 * @author Yg0R2
 */
public class BusinessLookUp {

	public BusinessService getBusinessService(String serviceType) {
		if (serviceType.equalsIgnoreCase("EJB")) {
			return new EJBService();
		}

		return new JMSService();
	}

}