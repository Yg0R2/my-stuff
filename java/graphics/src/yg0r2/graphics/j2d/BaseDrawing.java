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

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Yg0R2
 * @see http://www.javaworld.com/article/2076715/java-se/getting-started-with-java-2d.html
 */
@SuppressWarnings("serial")
public class BaseDrawing extends Frame {

	static final int WINDOW_HEIGHT = 480;
	static final int WINDOW_WIDTH = 640;

	public BaseDrawing(String title) {
		super(title);

		// Set the size of the frame.
		setSize(new Dimension(WINDOW_WIDTH, WINDOW_WIDTH));

		// Set visibility of our frame.
		setVisible(true);

		// We want to be sure, about the proper dispose of the frame.
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

}
