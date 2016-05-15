/**
 * 
 */
package yg0r2.designpattern.proxy;

/**
 * @author Yg0R2
 */
public class RealImage implements Image {

	private String _fileName;

	public RealImage(String fileName) {
		_fileName = fileName;

		_loadFromDisk(fileName);
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.proxy.Image#display()
	 */
	@Override
	public void display() {
		System.out.println("Displaying " + _fileName);
	}

	private void _loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}

}