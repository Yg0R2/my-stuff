/**
 * 
 */
package yg0r2.designpattern.businessdelegate;

/**
 * @author Yg0R2
 */
public class JMSService implements BusinessService {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.businessdelegate.BusinessService#doProcessing()
	 */
	@Override
	public void doProcessing() {
		System.out.println("Processing task by invoking JMS Service");
	}

}