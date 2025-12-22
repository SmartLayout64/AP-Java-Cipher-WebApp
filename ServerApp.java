import java.io.*;
import java.net.*;
import java.util.*;


public class ServerApp {
	// public static void main(String[] args) {
	// 	try (ServerSocket serverSocket = new ServerSocket(5000)){
	// 		InetAddress localhost = InetAddress.getLocalHost();
	// 		System.out.println("[SERVER] IP address is " + localhost.getHostAddress().trim());
	//         System.out.println("[SERVER] Server started on port 5000.");

	//         Socket socket = serverSocket.accept();
	//         System.out.println("[SERVER] Client 1 Connected");

	//         DataInputStream in = new DataInputStream(socket.getInputStream());
	//         String msg = "";

	//         while (!msg.equals("!~DISCONNECT~!")) {
	//             msg = in.readUTF();
	//             System.out.println("[CLIENT 1] " + msg);
	//         }

	//         System.out.println("[SERVER] Client 1 Connection Closed.");
	//     } catch (IOException e) {
	//         e.printStackTrace();
	//     }
	// }
}