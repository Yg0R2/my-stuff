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
