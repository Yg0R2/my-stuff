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
package yg0r2.minecraft.spring;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.core.util.FileUtils;

/**
 * @author Yg0R2
 */
public class BeanUtil {

	private static final Logger _LOGGER = LoggerFactory.getLogger(BeanUtil.class);

	/**
	 * Download the <code>&lt;T extends BaseBean&gt;</code> type bean.
	 *
	 * @param type
	 * @param downloadLocation
	 * @throws IOException
	 */
	public static <T extends BaseBean> void download(T type, Path downloadLocation) throws IOException {
		Path downloadLocationPath = Paths.get(downloadLocation + "/" + type.getFileName());

		if (Files.exists(downloadLocationPath)) {
			if (!FileUtils.isZipCorrupt(downloadLocationPath)) {
				_LOGGER.info("File '" + type.getFileName() + "' already exist.");

				return;
			}

			Files.delete(downloadLocationPath);
		}

		_LOGGER.info("Download '" + type.getFileName() + "' to " + downloadLocationPath);

		_LOGGER.debug("URL: " + type.getDownloadURL().toString());

		URL url = type.getDownloadURL();
		URLConnection connection = url.openConnection();
		connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

		Files.copy(connection.getInputStream(), downloadLocationPath);
	}

}
