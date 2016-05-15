/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public class VeganBurger extends Burger {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#name()
	 */
	@Override
	public String name() {
		return "Vegan Burger";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#price()
	 */
	@Override
	public float price() {
		return 25.0f;
	}

}