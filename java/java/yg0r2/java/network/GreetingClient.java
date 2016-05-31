/**
 * 
 */
package yg0r2.java.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 */
public class GreetingClient extends Thread {

	private static Logger _logger = LoggerFactory.getLogger(GreetingClient.class);

	private String _serverName;
	private int _serverPort;

	public GreetingClient(String serverName, int serverPort) {
		_serverName = serverName;
		_serverPort = serverPort;
	}

	@Override
	public void run() {
		try {
			_logger.info("Connecting to " + _serverName + " on port " + _serverPort);

			Socket client = new Socket(_serverName, _serverPort);

			_logger.info("Just connected to " + client.getRemoteSocketAddress());

			OutputStream outToServer = client.getOutputStream();

			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from " + client.getLocalSocketAddress());

			InputStream inFromServer = client.getInputStream();

			DataInputStream in = new DataInputStream(inFromServer);

			_logger.info("Server says " + in.readUTF());

			client.close();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
