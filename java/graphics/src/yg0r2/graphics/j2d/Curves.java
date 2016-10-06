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
package yg0r2.graphics.j2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 * @author Yg0R2
 * @see http://www.javaworld.com/article/2076715/java-se/getting-started-with-java-2d.html
 */
@SuppressWarnings("serial")
public class Curves extends BaseDrawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Curves();
	}

	public Curves() {
		super("Java 2D Curves");
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		GeneralPath generalPath = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		generalPath.moveTo(100.0f, 100.0f);
		generalPath.lineTo(100.0f, 225.0f);
		generalPath.quadTo(200.0f, 200.0f, 325.0f, 225.0f);
		generalPath.curveTo(360.0f, 200.0f, 230.0f, 150.0f, 325.0f, 100.0f);
		generalPath.closePath();

		g2d.setColor(Color.green);
		g2d.fill(generalPath);
	}

}
