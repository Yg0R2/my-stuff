/**
 * 
 */
package yg0r2.designpattern.abstractfactory;

/**
 * @author Yg0R2
 */
public class Red implements Color {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.abstractfactory.Color#fill()
	 */
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}

}