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

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Yg0R2
 */
public class StringUtil {

	private static MessageDigest _messageDigest;

	/**
	 * Create a hash code based on the give String value.<br />
	 * The method can generate 2 types of hashes:
	 * <ul>
	 * <li>where the location of each character is important,</li>
	 * <li>where the location of each character is not important</li>
	 * </ul>
	 *
	 * @param s The given String input.
	 * @param isDigitMatters Decide the location of the characters are important or not.
	 * @return With a generated hash code.
	 */
	public static long getHashCode(String s, boolean isDigitMatters) {
		if (s == null) {
			return 0;
		}

		long hash = s.length();

		for (int i = 0; i < s.length(); i++) {
			_messageDigest.reset();

			byte[] bytes = ByteBuffer.allocate(4).putInt(s.charAt(i)).array();

			_messageDigest.update(bytes);

			if (isDigitMatters) {
				hash = hash + (new BigInteger(1, _messageDigest.digest())).longValue() * (i + 1);
			}
			else {
				hash = hash * (new BigInteger(1, _messageDigest.digest())).longValue();
			}
		}

		return hash;
	}

	static {
		try {
			_messageDigest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
