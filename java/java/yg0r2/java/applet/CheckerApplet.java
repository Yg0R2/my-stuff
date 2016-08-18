/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
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

	@Override
	public void init() {
		String squareSizeParam = getParameter("squareSize");

		_parseSquareSize(squareSizeParam);

		String colorParam = getParameter("color");

		Color fg = _parseColor(colorParam);

		setBackground(Color.BLACK);
		setForeground(fg);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	private Color _parseColor(String param) {
		return Color.getColor(param);
	}

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

}
