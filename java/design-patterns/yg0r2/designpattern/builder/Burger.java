/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public abstract class Burger implements Item {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#packing()
	 */
	@Override
	public Packing packing() {
		return new Wrapper();
	}

}