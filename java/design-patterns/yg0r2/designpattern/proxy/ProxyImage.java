/**
 * 
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