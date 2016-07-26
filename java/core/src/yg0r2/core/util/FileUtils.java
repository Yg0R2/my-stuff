/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yg0r2.core.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Yg0R2
 */
public class FileUtils {

	public static void write(String fileName, String content, boolean append) throws IOException {
		Path outputFilePath = Paths.get(fileName);

		if (Files.exists(outputFilePath) && !append) {
			Files.delete(outputFilePath);
		}

		if (Files.exists(outputFilePath)) {
			Files.createFile(outputFilePath);
		}

		if (append) {
			Files.write(outputFilePath, content.getBytes(), StandardOpenOption.APPEND);
		}
		else {
			Files.write(outputFilePath, content.getBytes());
		}
	}

}
