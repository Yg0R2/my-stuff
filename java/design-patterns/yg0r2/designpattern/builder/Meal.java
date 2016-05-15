/**
 * 
 */
package yg0r2.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class Meal {

	private List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCost() {
		float cost = 0.0f;

		for (Item item : items) {
			cost += item.price();
		}

		return cost;
	}

	public void showItems() {
		for (Item item : items) {
			StringBuilder sb = new StringBuilder(6);

			sb.append("Item : ");
			sb.append(item.name());
			sb.append(", Packing: ");
			sb.append(item.packing().pack());
			sb.append(", Price: ");
			sb.append(item.price());

			System.out.println(sb.toString());
		}
	}

}