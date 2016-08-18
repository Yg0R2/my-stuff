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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yg0R2
 */
public class ArgumentUtil {

	public static Map<String, String> getArgumentMap(String... args) {
		Map<String, String> argumentMap = new HashMap<>();

		int i = 0;
		while (args.length > i) {
			String key = args[i];

			if (key.startsWith("-")) {
				key = key.substring(1);
			}

			i++;

			String value = null;
			try {
				value = args[i];

				if (value.startsWith("-")) {
					value = null;
				}

				i--;
			}
			catch (IndexOutOfBoundsException e) {
			}

			argumentMap.put(key, value);
		}

		return argumentMap;
	}

}
