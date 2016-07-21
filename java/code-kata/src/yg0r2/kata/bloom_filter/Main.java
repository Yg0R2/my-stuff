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
package yg0r2.kata.bloom_filter;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import yg0r2.core.util.FileUtils;
import yg0r2.core.util.RandomUtil;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata05-bloom-filters/
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Path filePath = FileUtils.getTemporaryPath(new URL("http://codekata.com/data/wordlist.txt"), "wordlist.txt");

		BloomFilter<String> bloomFilter = new BloomFilter<>(100000000, 5);

		// Fill up the BloomFilter with words from the wordlist.txt
		Files.readAllLines(filePath, StandardCharsets.ISO_8859_1).forEach(line -> {
			bloomFilter.add(line);
		});

		for (int i = 0; i < 15; i++) {
			String rndString = RandomUtil.nextString(5);

			System.out.println(
				"Does dictionary contains '" + rndString + "' word: " + bloomFilter.maybeContains(rndString));

			bloomFilter.add(rndString);
		}
	}

}
