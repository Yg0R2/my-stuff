/**
 * 
 */
package yg0r2.designpattern.bridge;

/**
 * @author Yg0R2
 */
public abstract class Shape {

	protected DrawAPI drawAPI;

	protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();

}