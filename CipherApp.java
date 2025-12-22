import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CipherApp {
    private static Scanner scanner = new Scanner(System.in);
    
    /*
    Multiple predefined user interface prompts identified by a unique string ID.
    Returns user input as a string.
    */
    public static String getUserRequest(String id) {
        switch (id) {
            case "selection-cipherType":
                System.out.println("Select a cipher to use.\n\t1. Caesar Cipher\n\t2. Substitution Cipher\n\t3. Pair Shift Cipher\n");
				return scanner.nextLine();

			case "input-cipherKey":
                System.out.print("Enter the key to use: ");
				return scanner.nextLine();
            
            case "selection-keyed-cipherAction":
                System.out.println("Select an action.\n\t1. Encode a message\n\t2. Decode a message\n\t3. Change the current key\n\t4. Return to main menu\n");
				return scanner.nextLine();

            case "selection-unkeyed-cipherAction":
                System.out.println("Select an action.\n\t1. Encode a message\n\t2. Decode a message\n\t3. Return to main menu\n");
				return scanner.nextLine();

            case "input-messageEncrypt":
                System.out.print("Enter message to encrypt: ");
				return scanner.nextLine();

            case "input-messageDecrypt":
                System.out.print("Enter message to decrypt: ");
				return scanner.nextLine();

            default:
                System.out.println("UI Not Found");
                return "UI Not Found";
        }
    }

    public static void runCaesarCipher() {
        // todo user 
        String key = getUserRequest("input-cipherKey");
        Cipherable caesarCipher = new CaesarCipher(Integer.parseInt(key));

        String message = "";

        String action = "0";

        while (true) {
            action = getUserRequest("selection-keyed-cipherAction");

            switch (action) {
                case "1":
                    message = getUserRequest("input-messageEncrypt");
                    String encodedMessage = caesarCipher.encode(message);
                    System.out.println("Encoded Message: " + encodedMessage);
                    break;
                
                case "2":
                    message = getUserRequest("input-messageDecrypt");
                    String decodedMessage = caesarCipher.decode(message);
                    System.out.println("Decoded Message: " + decodedMessage);
                    break;
                
                case "3":
                    key = getUserRequest("input-cipherKey");
                    caesarCipher = new CaesarCipher(Integer.parseInt(key));
                    System.out.println("Key updated.");
                    break;
                
                case "4":
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid, please pick a valid option.");
            }

            if (action.equals("4")) {
                break;
            }
        }
    }

	public static void main(String[] args) {
		runCaesarCipher();
	}

    // public static void main(String[] args) {
    //     try (Socket socket = new Socket("192.168.1.204", 5000);
    //          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    //          Scanner scanner = new Scanner(System.in)) {

    //         System.out.println("[CLIENT] Connected to server.");
    //         String message = "";

    //         while (!message.equals("!~DISCONNECT")) {
    //             System.out.print("Enter message: ");
    //             message = scanner.nextLine();
                
    //             out.writeUTF(message);
    //             out.flush();
    //         }

    //         System.out.println("[CLIENT] Connection closed.");
    //     } catch (IOException e) {
    //         System.err.println("[CLIENT] Error: " + e.getMessage());
    //     }
    // }
}