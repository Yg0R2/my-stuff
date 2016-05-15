/**
 * 
 */
package yg0r2.designpattern.bridge;

/**
 * @author Yg0R2
 */
public class GreenCircle implements DrawAPI {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.bridge.DrawAPI#drawCircle(int, int, int)
	 */
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y: " + y + " ]");
	}

}