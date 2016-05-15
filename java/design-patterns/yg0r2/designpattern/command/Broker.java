/**
 * 
 */
package yg0r2.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class Broker {

	private List<Order> _orderList = new ArrayList<>();

	public void takeOrder(Order order) {
		_orderList.add(order);
	}

	public void placeOrders() {
		for (Order order : _orderList) {
			order.execute();
		}

		_orderList.clear();
	}

}