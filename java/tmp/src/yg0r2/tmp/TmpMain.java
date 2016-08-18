package yg0r2.tmp;

import java.util.OptionalInt;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import yg0r2.kata.bloom_filter.BloomFilter;

public class TmpMain {

	public static void main(String[] args) throws Exception {
		String s1 = "apple2";
		String s2 = "palep";

		OptionalInt result = s1.chars().filter(c -> s1.chars().filter(c2 -> c == c2).count() != s2.chars().filter(c2 -> c == c2).count()).findFirst();

		System.out.println("anagram: " + !result.isPresent());

		s1.chars().forEach(c -> {
			System.out.print((char) c + ": ");
			System.out.print(s1.chars().filter(c2 -> c == c2).count());
			System.out.print(", ");
			System.out.println(s2.chars().filter(c2 -> c == c2).count());
		});
	
	}

}
