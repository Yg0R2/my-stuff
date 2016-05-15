/**
 * 
 */
package yg0r2.designpattern.flyweight;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm
 */
public class Main {

	private static final String _colors[] = {"Red", "Green", "Blue", "White", "Black"};

	private static String getRandomColor() {
		return _colors[(int)(Math.random() * _colors.length)];
	}

	private static int getRandomX() {
		return (int)(Math.random() * 100 );
	}

	private static int getRandomY() {
		return (int)(Math.random() * 100);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}

}