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
package yg0r2.kata.trigram_algorithm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.core.util.FileUtils;
import yg0r2.core.util.RandomUtil;

/**
 * @author Yg0R2
 */
public class Trigram {

	private static final Logger _LOGGER = LoggerFactory.getLogger(Trigram.class);

	private Map<String, List<String>> _trigramMap;

	public Trigram() throws MalformedURLException, IOException {
		Path filePath = FileUtils.getTemporaryPath(new URL("http://www.gutenberg.org/ebooks/3005.txt.utf-8"),
			"TomSwiftAndHisAirshipByVictorAppleton.txt");

		List<String> lines = Files.readAllLines(filePath);

		_init(lines);
	}

	public String generateArticle(String startString1, String startString2, int wordCount) {
		List<String> words = new ArrayList<>(wordCount);

		words.add(startString1);
		words.add(startString2);

		try {
			for (int i = 2; i < wordCount; i++) {
				String key = words.get(i - 2) + " " + words.get(i - 1);

				if (!_trigramMap.containsKey(key)) {
					throw new NoResultException("There is no combination for: '" + key + "'.");
				}

				List<String> values = _trigramMap.get(key);
				words.add(values.get(RandomUtil.nextInt(values.size())));
			}
		}
		catch (NoResultException e) {
			_LOGGER.error(e.getMessage(), e);
		}

		StringBuilder sb = new StringBuilder(wordCount * 2);

		words.stream().forEach(word -> {
			sb.append(word);
			sb.append(" ");
		});

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(_trigramMap.size() * 6);

		_trigramMap.forEach((k, v) -> {
			sb.append("\"");
			sb.append(k);
			sb.append("\" => [\"");
			sb.append(v.stream().collect(Collectors.joining("\", \"")));
			sb.append("\"]");
			sb.append("\n");
		});

		return sb.toString();
	}

	private void _init(List<String> lines) {
		_trigramMap = new HashMap<>();

		for (String line : lines) {
			String[] words = line.split(" ");

			if (words.length < 2) {
				continue;
			}

			for (int i = 2; i < words.length; i++) {
				String key = words[i - 2] + " " + words[i - 1];

				List<String> trigramList = null;
				if (_trigramMap.containsKey(key)) {
					trigramList = _trigramMap.get(key);
				}
				else {
					trigramList = new ArrayList<>(1);
				}

				if (!trigramList.contains(words[i])) {
					trigramList.add(words[i]);
				}

				_trigramMap.put(key, trigramList);
			}
		}
	}

}
