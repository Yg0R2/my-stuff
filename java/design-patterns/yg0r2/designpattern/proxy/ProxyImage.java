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
package yg0r2.designpattern.proxy;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class ProxyImage implements Image {

	private String _fileName;
	private RealImage _realImage;

	public ProxyImage(String fileName) {
		_fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.proxy.Image#display()
	 */
	@Override
	public void display() {
		if (Validator.isNull(_realImage)) {
			_realImage = new RealImage(_fileName);
		}

		_realImage.display();
	}

}
