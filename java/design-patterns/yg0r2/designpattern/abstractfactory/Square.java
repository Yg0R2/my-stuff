/**
 * 
 */
package yg0r2.designpattern.abstractfactory;

/**
 * @author Yg0R2
 */
public class Square implements Shape {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.abstractfactory.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}