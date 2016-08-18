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
package yg0r2.java8.base64;

import java.util.Base64;
import java.util.UUID;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_base64.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Encode using base encoder
		byte[] stringBytes = "TutorialsPoint?java8".getBytes("utf-8");
		String base64encodedString = Base64.getEncoder().encodeToString(stringBytes);
		System.out.println("Base64 Encoded String (Basic): " + base64encodedString);
		System.out.println();

		// Decode String
		byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
		System.out.println("Decoded original String: " + new String(base64decodedBytes, "utf-8"));
		System.out.println();

		// Encode URL
		byte[] urlBytes = "TutorialsPoint?java8".getBytes("utf-8");
		String base64encodedURL = Base64.getUrlEncoder().encodeToString(urlBytes);
		System.out.println("Base64 Encoded String (URL): " + base64encodedURL);
		System.out.println();

		// Encode MIME
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			sb.append(UUID.randomUUID().toString());
		}

		byte[] mimeBytes = sb.toString().getBytes("utf-8");
		String mineEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
		System.out.println("Base64 Encoded String (MIME): " + mineEncodedString);
	}

}
