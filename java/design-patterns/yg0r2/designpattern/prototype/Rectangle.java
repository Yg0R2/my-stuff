/**
 * 
 */
package yg0r2.designpattern.prototype;

/**
 * @author Yg0R2
 */
public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.prototype.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}