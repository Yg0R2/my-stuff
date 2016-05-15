/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public class Coke extends ColdDrink {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#name()
	 */
	@Override
	public String name() {
		return "Coke";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Item#price()
	 */
	@Override
	public float price() {
		return 30.0f;
	}

}