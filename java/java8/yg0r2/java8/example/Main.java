/**
 *
 */
package yg0r2.java8.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_overview.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> names1 = new ArrayList<>();
		names1.add("Mahesh ");
		names1.add("Suresh ");
		names1.add("Ramesh ");
		names1.add("Naresh ");
		names1.add("Kalpesh ");

		List<String> names2 = new ArrayList<String>();
		names2.add("Mahesh ");
		names2.add("Suresh ");
		names2.add("Ramesh ");
		names2.add("Naresh ");
		names2.add("Kalpesh ");

		Main instance = new Main();

		System.out.println("Sort using Java 7 syntax:");

		instance._sortUsingJava7(names1);

		System.out.println(names1);

		System.out.println("Sort using Java 8 syntax:");

		instance._sortUsingJava8(names2);

		System.out.println(names2);
	}

	// Sort with Java7
	private void _sortUsingJava7(List<String> list) {
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// Sort with Java8
	private void _sortUsingJava8(List<String> list) {
		Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
	}

}
