/**
 * 
 */
package yg0r2.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_streams.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		List<Integer> integerList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		List<Double> doubleList = Arrays.asList(1.0, 2.0, 13.0, 4.0, 15.0, 6.0, 17.0, 8.0, 19.0);

		_countEmptyStrings(stringList);

		System.out.println("------------------------------------------------");

		_countLength3Strings(stringList);

		System.out.println("------------------------------------------------");

		_deleteEmptyStrings(stringList);

		System.out.println("------------------------------------------------");

		_mergeStrings(stringList);

		System.out.println("------------------------------------------------");

		_squareIntegers(integerList);

		System.out.println("------------------------------------------------");

		_maxDouble(doubleList);

		System.out.println("------------------------------------------------");

		_minDouble(doubleList);

		System.out.println("------------------------------------------------");

		_sumDouble(doubleList);

		System.out.println("------------------------------------------------");

		_averageDouble(doubleList);

		System.out.println("------------------------------------------------");

		_randomIntegers();

		System.out.println("------------------------------------------------");

		
	}

	private static void _averageDouble(List<Double> doubleList) {
		System.out.println("List: " + doubleList);

		System.out.println("[Java 7]");

		double sum = 0.0;

		for (Double d : doubleList) {
			sum += d;
		}

		double average = sum / doubleList.size();

		System.out.println("	Average Double: " + average);

		System.out.println("[Java 8]");

		DoubleSummaryStatistics stats = doubleList.stream().mapToDouble(x -> x).summaryStatistics();

		System.out.println("	Average Double: " + stats.getAverage());
	}

	private static void _countEmptyStrings(List<String> stringList) {
		System.out.println("List: " + stringList);

		System.out.println("[Java 7]");

		int count = 0;

		for (String s : stringList) {
			if (s.isEmpty()) {
				count++;
			}
		}

		System.out.println("	Count of empty Strings: " + count);

		System.out.println("[Java 8]");

		count = (int) stringList.stream().filter(string -> string.isEmpty()).count();

		System.out.println("	Count of empty Strings: " + count);

		count = (int) stringList.parallelStream().filter(string -> string.isEmpty()).count();

		System.out.println("	Count of empty Strings (Parallel): " + count);
	}

	private static void _countLength3Strings(List<String> stringList) {
		System.out.println("List: " + stringList);

		System.out.println("[Java 7]");

		int count = 0;

		for (String s : stringList) {
			if (s.length() == 3) {
				count++;
			}
		}

		System.out.println("	Count of 3 length Strings: " + count);

		System.out.println("[Java 8]");

		count = (int) stringList.stream().filter(string -> (string.length() == 3)).count();

		System.out.println("	Count of 3 length Strings: " + count);
	}

	private static void _deleteEmptyStrings(List<String> stringList) {
		System.out.println("List: " + stringList);

		System.out.println("[Java 7]");

		List<String> filteredList = new ArrayList<>();

		for (String s : stringList) {
			if (!s.isEmpty()) {
				filteredList.add(s);
			}
		}

		System.out.println("	List of non empty Strings: " + filteredList);

		System.out.println("[Java 8]");

		filteredList = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("	List of non empty Strings: " + filteredList);
	}

	private static void _maxDouble(List<Double> doubleList) {
		System.out.println("List: " + doubleList);

		System.out.println("[Java 7]");

		double max = doubleList.get(0);

		for (Double d : doubleList) {
			if (max < d) {
				max = d;
			}
		}

		System.out.println("	Max Double: " + max);

		System.out.println("[Java 8]");

		DoubleSummaryStatistics stats = doubleList.stream().mapToDouble(x -> x).summaryStatistics();

		System.out.println("	Max Double: " + stats.getMax());
	}

	private static void _mergeStrings(List<String> stringList) {
		System.out.println("List: " + stringList);

		System.out.println("[Java 7]");

		StringBuilder sb = new StringBuilder();

		for (String s : stringList) {
			// if (!s.isEmpty()) {
			sb.append(s);
			sb.append(", ");
			// }
		}

		sb.delete(sb.length() - 2, sb.length()-1);

		System.out.println("	Merged Strings: " + sb.toString());

		System.out.println("[Java 8]");

		String joined = stringList.stream()/* .filter(string -> !string.isEmpty()) */.collect(Collectors.joining(", "));

		System.out.println("	Merged Strings: " + joined);
	}

	private static void _minDouble(List<Double> doubleList) {
		System.out.println("List: " + doubleList);

		System.out.println("[Java 7]");

		double min = doubleList.get(0);

		for (Double d : doubleList) {
			if (min > d) {
				min = d;
			}
		}

		System.out.println("	Min Double: " + min);

		System.out.println("[Java 8]");

		DoubleSummaryStatistics stats = doubleList.stream().mapToDouble(x -> x).summaryStatistics();

		System.out.println("	Min Double: " + stats.getMin());
	}

	private static void _randomIntegers() {
		Random rnd = new Random();

		System.out.println("[Java 7]");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			sb.append(rnd.nextInt());
			sb.append(", "); 
		}

		sb.delete(sb.length() - 2, sb.length()-1);

		System.out.println("	10 random Integer: " + sb.toString());

		System.out.println("[Java 8]");

		System.out.print("	10 random Integer: ");

		rnd.ints().limit(10).sorted().forEach(System.out::println);

		System.out.println();
	}

	private static void _squareIntegers(List<Integer> integerList) {
		System.out.println("List: " + integerList);

		System.out.println("[Java 7]");

		List<Integer> squareList = new ArrayList<>();

		for (Integer i : integerList) {
			int square = i * i;

			// if (!squareList.contains(square)) {
			squareList.add(square);
			// }
		}

		System.out.println("	Squares Strings: " + squareList);

		System.out.println("[Java 8]");

		squareList = integerList.stream().map(i -> (i * i))/* .distinct() */.collect(Collectors.toList());

		System.out.println("	Squares Strings: " + squareList);
	}

	private static void _sumDouble(List<Double> doubleList) {
		System.out.println("List: " + doubleList);

		System.out.println("[Java 7]");

		double sum = 0.0;

		for (Double d : doubleList) {
			sum += d;
		}

		System.out.println("	Sum Double: " + sum);

		System.out.println("[Java 8]");

		DoubleSummaryStatistics stats = doubleList.stream().mapToDouble(x -> x).summaryStatistics();

		System.out.println("	Sum Double: " + stats.getSum());
	}

}
