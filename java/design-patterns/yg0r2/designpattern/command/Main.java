/**
 * 
 */
package yg0r2.designpattern.command;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/command_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stock abcStock = new Stock();

		BuyStock buyStock = new BuyStock(abcStock);

		SellStock sellStock = new SellStock(abcStock);

		Broker broker = new Broker();

		broker.takeOrder(buyStock);
		broker.takeOrder(sellStock);

		broker.placeOrders();
	}

}