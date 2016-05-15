/**
 * 
 */
package yg0r2.designpattern.businessdelegate;

/**
 * @author Yg0R2
 */
public class BusinessDelegate {

	private BusinessService _businessService;
	private BusinessLookUp _businessLookUpService = new BusinessLookUp();
	private String _serviceType;

	public void doTask() {
		_businessService = _businessLookUpService.getBusinessService(_serviceType);

		_businessService.doProcessing();
	}

	public void setServiceType(String serviceType) {
		_serviceType = serviceType;
	}

}