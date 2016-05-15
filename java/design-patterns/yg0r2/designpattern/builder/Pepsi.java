/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public class Pepsi extends ColdDrink {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#name()
	 */
	@Override
	public String name() {
		return "Pepsi";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#price()
	 */
	@Override
	public float price() {
		return 35.0f;
	}

}