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

import static java.security.AccessController.doPrivileged;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipFile;

import sun.security.action.GetPropertyAction;

/**
 * @author Yg0R2
 */
public class FileUtils {

	public static final String FILE_SEPARATOR = File.separator;

	/**
	 * Get the working directory, appends with the given <code>clazz</code>.class file package as location. Appends with
	 * the <code>srcFolderName</code>; then appends with the given <code>clazz</code>.java file name.
	 *
	 * @param clazz Use the location of this class file.
	 * @param srcFolderName The src folder location.
	 * @return With a concatenated location of the working directory, and the <code>srcFolderName</code> folder, and the
	 *         name of the <code>clazz</code>.
	 */
	public static Path getJavaPath(Class<?> clazz, String srcFolderName) {
		StringBuilder sb = new StringBuilder();
		sb.append(new File("").getAbsolutePath());
		sb.append(FILE_SEPARATOR);
		sb.append(srcFolderName);
		sb.append(FILE_SEPARATOR);
		sb.append(_getClassPackageAsLocation(clazz));
		sb.append(FILE_SEPARATOR);
		sb.append(clazz.getSimpleName());
		sb.append(".java");

		return Paths.get(sb.toString());
	}

	/**
	 * Use the location of the workspace as base folder. Appends with the <b>resources</b> folder name (which is the
	 * required location); then appends with the given <code>fileName</code> parameter.
	 *
	 * @param clazz Use the location of this class file.
	 * @param fileName This is the file name.
	 * @return With a concatenated location of the class, the 'resources' folder name, and the given file name.
	 */
	public static Path getResourcePath(Class<?> clazz, String fileName) {
		StringBuilder sb = new StringBuilder();
		sb.append(_getBaseLocation());
		sb.append(_getClassPackageAsLocation(clazz));
		sb.append(FILE_SEPARATOR);
		sb.append("resources");
		sb.append(FILE_SEPARATOR);
		sb.append(fileName);

		return Paths.get(sb.toString());
	}

	/**
	 * Download the file from the given <code>url</code> and saves it into the TMP folder with the given
	 * <code>fileName</code>.
	 *
	 * @param url This file will be downloaded.
	 * @param fileName The downloaded file will be saved with this file name.
	 * @return With the path of the downloaded file.
	 * @throws IOException
	 */
	public static Path getTemporaryPath(URL url, String fileName) throws IOException {
		return getTemporaryPath(url, fileName, false);
	}

	/**
	 * Download the file from the given <code>url</code> and saves it into the TMP folder with the given
	 * <code>fileName</code>.
	 *
	 * @param url This file will be downloaded.
	 * @param fileName The downloaded file will be saved with this file name.
	 * @param force Will delete the file first, then download it.
	 * @return With the path of the downloaded file.
	 * @throws IOException
	 */
	public static Path getTemporaryPath(URL url, String fileName, boolean force) throws IOException {
		String tmpFolderName = doPrivileged(new GetPropertyAction("java.io.tmpdir"));

		Path tmpFilePath = Paths.get(tmpFolderName + fileName);

		if (force) {
			Files.delete(tmpFilePath);
		}

		if (!Files.exists(tmpFilePath)) {
			Files.createFile(tmpFilePath);

			Files.copy(url.openStream(), tmpFilePath, StandardCopyOption.REPLACE_EXISTING);
		}

		return tmpFilePath;
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

	/**
	 * @return With the location of the workspace.
	 */
	private static String _getBaseLocation() {
		String basePath = FileUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();

		if (OSUtil.isWindows()) {
			basePath = basePath.substring(1);
		}

		return basePath;
	}

	/**
	 * Replace all dots (.) with file separator (/ or \).
	 *
	 * @param clazz The package of this class will be transformed a location.
	 * @return With a location part based on the package,
	 */
	private static String _getClassPackageAsLocation(Class<?> clazz) {
		return clazz.getPackage().getName().replace(".", FILE_SEPARATOR);
	}

}
