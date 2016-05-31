/**
 * 
 */
package yg0r2.java.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java/java_applet_basics.htm
 */
public class CheckerApplet extends Applet {

	private int _squareSize = 50;

	private void _parseSquareSize(String param) {
		if (param == null) {
			return;
		}

		try {
			_squareSize = Integer.parseInt(param);
		}
		catch (Exception e) {
		}
	}

	private Color _parseColor(String param) {
		return Color.getColor(param);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void init() {
		String squareSizeParam = getParameter("squareSize");

		_parseSquareSize(squareSizeParam);

		String colorParam = getParameter("color");

		Color fg = _parseColor(colorParam);

		setBackground(Color.BLACK);
		setForeground(fg);
	}

}
