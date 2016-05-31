/**
 * 
 */
package yg0r2.java.applet;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java/java_applet_basics.htm
 */
@SuppressWarnings("serial")
public class HelloWorldApplet extends Applet {

	@Override
	public void paint(Graphics graphics) {
		graphics.drawString("Hello World!", 25, 50);
	}

}
