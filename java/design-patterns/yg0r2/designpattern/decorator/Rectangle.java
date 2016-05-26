/**
 * 
 */
package yg0r2.designpattern.decorator;

/**
 * @author Yg0R2
 */
public class Rectangle implements Shape {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.decorator.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}

}