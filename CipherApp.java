import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CipherApp {
    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.1.204", 5000);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("[CLIENT] Connected to server.");
            String message = "";

            while (!message.equals("!~DISCONNECT")) {
                System.out.print("Enter message: ");
                message = scanner.nextLine();
                
                out.writeUTF(message);
                out.flush();
            }

            System.out.println("[CLIENT] Connection closed.");
        } catch (IOException e) {
            System.err.println("[CLIENT] Error: " + e.getMessage());
        }
    }
}