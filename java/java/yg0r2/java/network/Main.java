/**
 * 
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
