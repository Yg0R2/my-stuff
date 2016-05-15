/**
 * 
 */
package yg0r2.designpattern.prototype;

/**
 * @author Yg0R2
 */
public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.prototype.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}