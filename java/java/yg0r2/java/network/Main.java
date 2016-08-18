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
package yg0r2.java.network;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java/java_networking.htm
 */
public class Main {

	public static final String SERVER_NAME = "localhost";
	public static final Integer SERVER_PORT = 6066;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Thread serverThread = new GreetingServer(SERVER_PORT);

		serverThread.start();

		Thread.sleep(5000);

		Thread clientThread = new GreetingClient(SERVER_NAME, SERVER_PORT);

		clientThread.start();

	}

}
