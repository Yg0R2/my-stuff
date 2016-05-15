/**
 * 
 */
package yg0r2.designpattern.decorator;

/**
 * @author Yg0R2
 */
public class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape shape) {
		decoratedShape = shape;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.decorator.Shape#draw()
	 */
	@Override
	public void draw() {
		decoratedShape.draw();
	}

}