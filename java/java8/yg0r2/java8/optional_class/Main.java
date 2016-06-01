/**
 * 
 */
package yg0r2.java8.optional_class;

import java.util.Optional;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_optional_class.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main instance = new Main();

		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);

		System.out.println(instance.sum(a, b));
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returns the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();

		return value1 + value2;
	}

}
