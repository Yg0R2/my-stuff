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
package yg0r2.kata.conflicting_objectives;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.core.util.FileUtils;
import yg0r2.core.util.StringUtil;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata08-conflicting-objectives/
 */
public class Main {

	private static Logger _logger = LoggerFactory.getLogger(Main.class);
	private static int _MAX_LENGTH = 6;

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

		Map<String, List<String>> foundWordsMap = instance.proceed(words);

		long end = System.nanoTime();

		_logger.info("Anagram search took: " + ((end - start) / 1000000000) + "s");

		_logger.info("Count of found anagrams: " + foundWordsMap.size());

		foundWordsMap.forEach((k, v) -> {
			_logger.info(v.stream().collect(Collectors.joining(", ")) + " => " + k);
		});
	}

	protected Map<String, List<String>> proceed(List<String> words) {
		Map<Long, String> searchedWords = new HashMap<>(1000000);
		Map<Integer, List<String>> acceptableWords = new HashMap<>(_MAX_LENGTH - 1);

		for (String word : words) {
			int wordLength = word.length();

			if (wordLength > _MAX_LENGTH) {
				continue;
			}
			else if (wordLength == _MAX_LENGTH) {
				searchedWords.put(StringUtil.getHashCode(word, true), word);

				continue;
			}

			if (!acceptableWords.containsKey(wordLength)) {
				acceptableWords.put(wordLength, new ArrayList<>(100000));
			}

			acceptableWords.get(wordLength).add(word);
		}

		Map<String, List<String>> foundWordsMap = new HashMap<>(10000);

		for (int i = 1; i < _MAX_LENGTH; i++) {
			List<String> s1List = acceptableWords.get(i);
			List<String> s2List = acceptableWords.get(_MAX_LENGTH - i);

			s1List.stream().forEach(s1 -> {
				s2List.stream().forEach(s2 -> {
					long hash = StringUtil.getHashCode(s1 + s2, true);

					if (searchedWords.containsKey(hash)) {
						if (!foundWordsMap.containsKey(hash)) {
							foundWordsMap.put(searchedWords.get(hash), new ArrayList<>());
						}

						foundWordsMap.get(searchedWords.get(hash)).add(s1 + " + " + s2);
					}
				});
			});
		}

		return foundWordsMap;
	}

}
