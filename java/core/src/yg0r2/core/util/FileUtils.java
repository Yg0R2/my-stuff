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
package yg0r2.core.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipFile;

/**
 * @author Yg0R2
 */
public class FileUtils {

	/**
	 * Use the location of the given <code>clazz</code>.class file as the base folder. Appends with the <b>resources</b>
	 * folder name (which is the required location); then appends with the given <code>fileName</code> parameter.
	 *
	 * @param clazz Use the location of this class file.
	 * @param fileName This is the file name.
	 * @return With a concatenated location of the class, the 'resources' folder name, and the given file name.
	 */
	public static Path getResourcePath(Class<?> clazz, String fileName) {
		String basePath = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();

		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			basePath = basePath.substring(1);
		}

		String classPackagePath = clazz.getPackage().getName().replace(".", "/");

		String filePath = basePath + classPackagePath + "/resources/" + fileName;

		return Paths.get(filePath);
	}

	/**
	 * Check the file on the given path is corrupted zip file or not.
	 *
	 * @param zipFileLocation
	 * @return is the zip file is corrupt or not.
	 */
	public static boolean isZipCorrupt(Path zipFileLocation) {
		try (ZipFile zipFile = new ZipFile(zipFileLocation.toFile())) {
			return false;
		}
		catch (IOException e) {
			// Ignore
		}

		return true;
	}

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
