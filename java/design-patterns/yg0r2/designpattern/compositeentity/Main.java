/**
 * 
 */
package yg0r2.designpattern.compositeentity;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/composite_entity_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client();

		client.setData("Test", "Data");

		client.printData();

		client.setData("Second Test", "Data1");

		client.printData();
	}

}