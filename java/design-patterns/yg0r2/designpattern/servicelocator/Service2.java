/**
 * 
 */
package yg0r2.designpattern.servicelocator;

/**
 * @author Yg0R2
 */
public class Service2 implements Service {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.servicelocator.Service#execute()
	 */
	@Override
	public void execute() {
		System.out.println("Executing Service2");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.servicelocator.Service#getName()
	 */
	@Override
	public String getName() {
		return "Service2";
	}

}