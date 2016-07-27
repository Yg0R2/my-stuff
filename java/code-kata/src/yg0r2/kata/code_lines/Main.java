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
package yg0r2.kata.code_lines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.core.util.FileUtils;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata13-counting-code-lines/
 */
public class Main {

	private static Logger _LOGGER = LoggerFactory.getLogger(Main.class);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Inline comment

		Path filePath = FileUtils.getJavaPath(Main.class, "code-kata/src");

		Main instance = new Main();

		_LOGGER.info("The file contains " + instance.countLineNumbersOfCode(filePath) + " lines of pure code.");
	}

	protected int countLineNumbersOfCode(Path filePath) throws IOException {
		List<String> lines = Files.readAllLines(filePath);

		int lineCount = 0;

		Pattern commentLinePattern = Pattern.compile("(\t*|(    )*)((/\\*)|( \\*)|( \\*/)|(//)|(.*?\\*/))(.*)");
		Pattern emptyLinePattern = Pattern.compile("((^$)|(\t+)|( +))");

		for (String line : lines) {
			Matcher commentLineMatcher = commentLinePattern.matcher(line);
			Matcher emptlyLineMatcher = emptyLinePattern.matcher(line);

			if (commentLineMatcher.matches() || emptlyLineMatcher.matches()) {
				continue;
			}

			lineCount++;

			_LOGGER.debug(line);
		}

		return lineCount;
	}

}
