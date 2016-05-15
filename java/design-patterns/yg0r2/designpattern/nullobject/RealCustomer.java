/**
 * 
 */
package yg0r2.designpattern.nullobject;

/**
 * @author Yg0R2
 */
public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.nullobject.AbstractCustomer#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.nullobject.AbstractCustomer#isNil()
	 */
	@Override
	public boolean isNil() {
		return false;
	}

}