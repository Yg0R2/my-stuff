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
package yg0r2.kata.trigram_algorithm;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author Yg0R2
 * @see http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		Trigram trigram = new Trigram();

		// System.out.println(trigram.toString());

		System.out.println(trigram.generateArticle("I", "have", 20));
	}

}
