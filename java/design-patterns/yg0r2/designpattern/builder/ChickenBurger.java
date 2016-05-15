/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public class ChickenBurger extends Burger {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#name()
	 */
	@Override
	public String name() {
		return "Chicken Burger";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#price()
	 */
	@Override
	public float price() {
		return 50.5f;
	}

}