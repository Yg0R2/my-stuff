/**
 * 
 */
package yg0r2.designpattern.businessdelegate;

/**
 * @author Yg0R2
 */
public class Client {

	private BusinessDelegate _businessDelegateService;

	public Client(BusinessDelegate businessDelegateService) {
		_businessDelegateService = businessDelegateService;
	}

	public void doTask() {
		_businessDelegateService.doTask();
	}

}