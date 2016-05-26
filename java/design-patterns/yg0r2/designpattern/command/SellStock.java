/**
 * 
 */
package yg0r2.designpattern.command;

/**
 * @author Yg0R2
 */
public class SellStock implements Order {

	private Stock _abcStock;

	public SellStock(Stock stock) {
		_abcStock = stock;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.command.Order#execute()
	 */
	@Override
	public void execute() {
		_abcStock.sell();
	}

}