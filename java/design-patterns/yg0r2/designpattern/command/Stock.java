/**
 * 
 */
package yg0r2.designpattern.command;

/**
 * @author Yg0R2
 */
public class Stock {

	private String _name = "ABC";
	private int _quantity = 10;

	public void buy() {
		System.out.println("Stock [ Name: " + _name + ", Quantity: " + _quantity + "] bought");
	}

	public void sell() {
		System.out.println("Stock [ Name: " + _name + ", Quantity: " + _quantity + "] sold");
	}

}