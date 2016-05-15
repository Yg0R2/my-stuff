/**
 * 
 */
package yg0r2.designpattern.factory;

/**
 * @author Yg0R2
 */
public class Rectangle implements Shape {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.factory.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}