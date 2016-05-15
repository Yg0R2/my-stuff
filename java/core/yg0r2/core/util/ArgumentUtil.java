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
		while(args.length > i) {
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