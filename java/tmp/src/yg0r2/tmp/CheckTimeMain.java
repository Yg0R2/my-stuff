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
package yg0r2.tmp;

import java.util.ArrayList;
import java.util.List;

import yg0r2.tmp.Apple.Banana;

/**
 * @author Yg0R2
 */
public class CheckTimeMain {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int count = 20000000;

		System.out.println("Sleep..");
		Thread.sleep(10000);

		doCheckTimeGetter(count);

		System.out.println("Sleep..");
		Thread.sleep(10000);

		doCheckTimeNewInstance(count);

		Thread.sleep(10000);
	}

	protected static void doCheckTimeGetter(int count) {
		List<String> list = new ArrayList<>(count);

		long start = System.nanoTime();

		for (int i = 0; i < count; i++) {
			Apple a = new Apple(10);

			if (a.getBanana() != null) {
				list.add(a.getBanana().getNumber());
			}
		}

		long end = System.nanoTime();

		System.out.println("Took getter: " + (end - start));
	}

	protected static void doCheckTimeNewInstance(int count) {
		List<String> list = new ArrayList<>(count);

		long start = System.nanoTime();

		for (int i = 0; i < count; i++) {
			Apple a = new Apple(10);

			Banana b = a.getBanana();
			if (b != null) {
				list.add(b.getNumber());
			}
		}

		long end = System.nanoTime();

		System.out.println("Took new instance: " + (end - start));
	}

}

class Apple {

	class Banana {

		private int _number;

		public Banana(int number) {
			_number = number;
		}

		public String getNumber() {
			return "Number of bananas: " + _number;
		}
	}

	private Banana _banana;

	public Apple(int bananaNumber) {
		_banana = new Banana(bananaNumber);
	}

	public Banana getBanana() {
		return _banana;
	}
}
