/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public class Bottle implements Packing {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.builder.Packing#pack()
	 */
	@Override
	public String pack() {
		return "Bottle";
	}

}