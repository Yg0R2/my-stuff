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
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 * @author Yg0R2
 * @see http://www.javaworld.com/article/2076715/java-se/getting-started-with-java-2d.html
 */
@SuppressWarnings("serial")
public class Square extends BaseDrawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Square();
	}

	public Square() {
		super("Java 2D Square");
	}

	@Override
	public void paint(Graphics g) {
		// We used to draw like this.
		g.setColor(Color.RED);
		g.drawRect(50, 50, 200, 200);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.BLUE);
		g2d.drawRect(75, 75, 300, 200);

		GeneralPath generalPath = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		generalPath.moveTo(0.0f, 0.0f);
		generalPath.lineTo(0.0f, 125.0f);
		generalPath.lineTo(225.0f, 125.0f);
		generalPath.lineTo(225.0f, 0.0f);
		generalPath.closePath();

		AffineTransform affineTransform = new AffineTransform();
		affineTransform.setToRotation(-Math.PI / 8.0);
		g2d.transform(affineTransform);
		affineTransform.setToTranslation(50.0f, 200.0f);
		g2d.transform(affineTransform);

		g2d.setColor(Color.GREEN);
		g2d.fill(generalPath);
	}

}
