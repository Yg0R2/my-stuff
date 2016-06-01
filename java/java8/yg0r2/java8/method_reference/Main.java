/**
 * 
 */
package yg0r2.java8.method_reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_method_references.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);
	}

}
