import java.io.*;
import java.net.*;
import java.util.*;


public class ServerApp {
	private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String getUserRequest(String id) {
        switch (id) {
            case "selection-cipherType":
                System.out.println("Select a cipher to use.\n\t1. Caesar Cipher\n\t2. Substitution Cipher\n\t3. Pair Shift Cipher\n");
				return scanner.nextLine();

			case "input-cipherKey":
                System.out.print("Enter the key to use: ");
				return scanner.nextLine();
            
            case "selection-keyed-cipherAction":
                System.out.println("Select an action.\n\t1. Encode a message\n\t2. Decode a message\n\t3. Change the current key\n");
				return scanner.nextLine();

            case "selection-unkeyed-cipherAction":
                System.out.println("Select an action.\n\t1. Encode a message\n\t2. Decode a message\n");
				return scanner.nextLine();

            default:
                return "UI Not Found";
        }
    }

	public static void main(String[] args) {
		System.out.println(getUserRequest("selection-cipherType"));


	}

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