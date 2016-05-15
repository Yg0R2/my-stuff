/**
 * 
 */
package yg0r2.designpattern.proxy;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		//image will be loaded from disk
		image.display(); 
		System.out.println("");

		//image will not be loaded from disk
		image.display(); 	
	}

}