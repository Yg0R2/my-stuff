/**
 * 
 */
package yg0r2.java.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 */
public class GreetingServer extends Thread {

	private static Logger _logger = LoggerFactory.getLogger(GreetingServer.class);

	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	@Override
	public void run() {
		while (true) {
			try {
				_logger.info("Waiting for client on port " + serverSocket.getLocalPort() + "...");

				Socket server = serverSocket.accept();

				_logger.info("Just connected to " + server.getRemoteSocketAddress());

				DataInputStream in = new DataInputStream(server.getInputStream());

				_logger.info(in.readUTF());

				DataOutputStream out = new DataOutputStream(server.getOutputStream());

				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");

				server.close();
			}
			catch (SocketTimeoutException s) {
				_logger.info("Socket timed out!");

				break;
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
