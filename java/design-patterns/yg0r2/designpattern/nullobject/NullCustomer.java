/**
 * 
 */
package yg0r2.designpattern.nullobject;

/**
 * @author Yg0R2
 */
public class NullCustomer extends AbstractCustomer {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.nullobject.AbstractCustomer#getName()
	 */
	@Override
	public String getName() {
		return "Not Available in Customer Database";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.nullobject.AbstractCustomer#isNil()
	 */
	@Override
	public boolean isNil() {
		return true;
	}

}