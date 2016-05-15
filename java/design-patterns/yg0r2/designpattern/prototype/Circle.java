/**
 * 
 */
package yg0r2.designpattern.prototype;

/**
 * @author Yg0R2
 */
public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.prototype.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}