import java.io.*;
import java.net.*;

public class ServerApp {
    public static String getUi(String id) {
        switch (id) {
            case "selection-cipherType":
                return "Select a cipher to use.\n\t1. Caesar Cipher\n\t2. Substitution Cipher\n\t3. Pair Shift Cipher\n\n";
            
            case "selection-keyed-cipherAction":
                return "Select an action.\n\t1. Encode a message\n\t2. Decode a message\n\t3. Change the current key\n\n";

            case "selection-unkeyed-cipherAction":
                return "Select an action.\n\t1. Encode a message\n\t2. Decode a message\n\n";

            default:
                return "UI Not Found";
        }
    }

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(5000)){
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("[SERVER] IP address is " + localhost.getHostAddress().trim());
	        System.out.println("[SERVER] Server started on port 5000.");

	        Socket socket = serverSocket.accept();
	        System.out.println("[SERVER] Client 1 Connected");

	        DataInputStream in = new DataInputStream(socket.getInputStream());
	        String msg = "";

	        while (!msg.equals("!~DISCONNECT~!")) {
	            msg = in.readUTF();
	            System.out.println("[CLIENT 1] " + msg);
	        }

	        System.out.println("[SERVER] Client 1 Connection Closed.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}