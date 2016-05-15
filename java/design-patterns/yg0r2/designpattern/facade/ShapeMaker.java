/**
 * 
 */
package yg0r2.designpattern.facade;

/**
 * @author Yg0R2
 */
public class ShapeMaker {

	private Shape _circle;
	private Shape _rectangle;
	private Shape _square;

	public ShapeMaker() {
		_circle = new Circle();
		_rectangle = new Rectangle();
		_square = new Square();
	}

	public void drawCircle() {
		_circle.draw();
	}

	public void drawRectangle() {
		_rectangle.draw();
	}

	public void drawSquare() {
		_square.draw();
	}

}