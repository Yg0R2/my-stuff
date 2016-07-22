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
package yg0r2.kata.anagrams;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.core.util.FileUtils;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata06-anagrams/
 */
public class Main {

	private static Logger _logger = LoggerFactory.getLogger(Main.class);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Path filePath = FileUtils.getTemporaryPath(new URL("http://codekata.com/data/wordlist.txt"), "wordlist.txt");

		List<String> words = Files.readAllLines(filePath, StandardCharsets.ISO_8859_1);

		_logger.info("Start...");

		long start = System.nanoTime();

		Main instance = new Main();

		List<Anagram> anagrams = instance.proceed(words);

		long end = System.nanoTime();

		_logger.info("Anagram search took: " + ((end - start) / 1000000) + "ms");

		_logger.info("Count of found anagrams: " + anagrams.size());

		anagrams.forEach(anagram -> {
			_logger.info(anagram.getWord() + ": " + anagram.getAnagrams().stream().collect(Collectors.joining(", ")));
		});
	}

	protected List<Anagram> proceed(List<String> words) {
		Map<Long, Anagram> anagramMap = new HashMap<>(1000000);

		words.stream().forEach(word -> {
			Anagram anagram = new Anagram(word);

			long anagramHash = anagram.getHashCode();

			if (anagramMap.containsKey(anagramHash)) {
				anagramMap.get(anagramHash).putAnagram(word);
			}
			else {
				anagramMap.put(anagramHash, anagram);
			}
		});

		return anagramMap.values().stream().filter(anagram -> !anagram.getAnagrams().isEmpty())
			.collect(Collectors.toList());
	}

}
