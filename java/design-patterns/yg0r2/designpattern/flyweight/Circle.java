/**
 * 
 */
package yg0r2.designpattern.flyweight;

/**
 * @author Yg0R2
 */
public class Circle implements Shape {

	private String _color;
	private int _radius;
	private int _x;
	private int _y;

	public Circle(String color) {
		_color = color;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.flyweight.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Circle [ color : " + _color + ", radius : " + _radius + ", x : " + _x + ", y : " + _y + " ]"); 
	}

	public void setRadius(int radius) {
		_radius = radius;
	}

	public void setX(int x) {
		_x = x;
	}

	public void setY(int y) {
		_y = y;
	}

}