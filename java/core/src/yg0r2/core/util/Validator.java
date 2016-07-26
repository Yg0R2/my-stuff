/**
 * 
 */
package yg0r2.core.util;

/**
 * @author Yg0R2
 */
public class Validator {

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}

		obj = String.valueOf(obj);

		if (obj.equals("") || obj.equals("null")) {
			return true;
		}

		return false;
	}


}