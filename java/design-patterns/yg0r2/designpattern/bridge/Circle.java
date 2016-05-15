/**
 * 
 */
package yg0r2.designpattern.bridge;

/**
 * @author Yg0R2
 */
public class Circle extends Shape {

	private int _radius, _x, _y;

	protected Circle(int radius, int x, int y, DrawAPI drawAPI) {
		super(drawAPI);

		_radius = radius;

		_x = x;

		_y = y;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.bridge.Shape#draw()
	 */
	@Override
	public void draw() {
		drawAPI.drawCircle(_radius, _x, _y);
	}

}