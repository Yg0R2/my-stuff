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

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import jodd.util.ReflectUtil;

/**
 * @author Yg0R2
 */
public class IOUtil {

	public static void close(Closeable closeable) throws IOException {
		closeable.close();
	}

	public static void close(Object obj) throws IOException {
		try {
			ReflectUtil.invoke(obj, "close", new Object[0]);
		}
		catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new IOException(e);
		}
	}

	public static void closeSilently(Closeable closeable) {
		if (closeable == null) {
			return;
		}

		try {
			close(closeable);
		}
		catch (IOException e) {
		}
	}

	public static void closeSilently(Object obj) {
		try {
			close(obj);
		}
		catch (IOException e) {
		}
	}

}
