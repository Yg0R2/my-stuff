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
