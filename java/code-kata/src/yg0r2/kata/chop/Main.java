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
package yg0r2.kata.chop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata02-karate-chop/
 */
public class Main {

	private static Logger _logger = LoggerFactory.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<Integer> list = getSortedList(100000);

		int searchNumber = 199992;

		_logger.info("--------------------------------------");
		_logger.info(list.toString());
		_logger.info("--------------------------------------");

		try {
			for (int i = 1; i <= 5; i++) {
				Class<Chop> chopClazz = Chop.class;
				Method searchMethod =
					chopClazz.getDeclaredMethod("search" + i, new Class<?>[] { Integer.TYPE, List.class });

				_logger.info("--------------------------------------");
				_logger.info("Start search after: " + searchNumber);

				long start = System.nanoTime();

				int index = (int) searchMethod.invoke(new Chop(), new Object[] { searchNumber, list });

				if (index == -1) {
					_logger.info("The requested number is not in the list.");
				}
				else {
					_logger.info("The requested number is in the list in " + index + " position.");
				}

				long end = System.nanoTime();

				_logger.info("Took: " + String.valueOf((end - start) / 1000) + "µs");
				_logger.info("--------------------------------------");
			}
		}
		catch (NoSuchMethodException e) {
			// Ignore, not implemented methods..
		}

	}

	protected static List<Integer> getSortedList(int size) {
		Random rnd = new Random();

		SortedSet<Integer> set = new TreeSet<>();

		while (set.size() < size) {
			set.add(rnd.nextInt(size * 2));
		}

		return new ArrayList<>(set);
	}

}
