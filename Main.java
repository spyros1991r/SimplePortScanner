/**
 * 
 */
package scanPorts;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Master
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String host;
		String text;
		// if not exactly one host is not given
		if (args.length != 1) {
			System.out.println("Please give the name of the host to scan as " + "a parameter to the program");
			System.exit(1);
		}

		host = args[0];

		for (int port = 0; port <= 65535; port++) {
			try {
				Socket socket = new Socket(host, port);
				text = host + " is listening on port " + port;
				System.out.println(text);
				socket.close();
			} catch (UnknownHostException e) {
				System.out.println("The IP address of the host " + "could not be determined");
				System.exit(1);
			} catch (SecurityException e) {
				System.out.println(
						"A security manager exists " + "and its checkConnect method doesn't allow the operation.");
				System.exit(1);
			} catch (IllegalArgumentException e) {
				System.out.println("he port parameter is outside the specified range of valid port values, "
						+ "which is between 0 and 65535, inclusive");
				System.exit(1);
			} catch (IOException e) {
				//System.out.println("An IO exception has occured");
				//System.exit(1);
			}
		}
	}
}
