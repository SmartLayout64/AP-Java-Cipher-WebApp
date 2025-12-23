import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CipherApp {
    private static Scanner scanner = new Scanner(System.in);
    
    /*
    Clears the console screen and displays a title header.
    */

    public static void clearScreen(String title) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (title) {
            case "caesar-cipher":
                System.out.println("\n" + //
                                "█▀▀ ▄▀█ █▀▀ █▀ ▄▀█ █▀█   █▀▀ █ █▀█ █░█ █▀▀ █▀█\n" + //
                                "█▄▄ █▀█ ██▄ ▄█ █▀█ █▀▄   █▄▄ █ █▀▀ █▀█ ██▄ █▀▄");
                break;
        
            case "substitution-cipher":
                System.out.println("\n" + //
                                        "█▀ █░█ █▄▄ █▀ ▀█▀ █ ▀█▀ █░█ ▀█▀ █ █▀█ █▄░█   █▀▀ █ █▀█ █░█ █▀▀ █▀█\n" + //
                                        "▄█ █▄█ █▄█ ▄█ ░█░ █ ░█░ █▄█ ░█░ █ █▄█ █░▀█   █▄▄ █ █▀▀ █▀█ ██▄ █▀▄");
                break;

            case "pairshift-cipher":
                System.out.println("\n" + //
                                        "█▀█ ▄▀█ █ █▀█   █▀ █░█ █ █▀▀ ▀█▀   █▀▀ █ █▀█ █░█ █▀▀ █▀█\n" + //
                                        "█▀▀ █▀█ █ █▀▄   ▄█ █▀█ █ █▀░ ░█░   █▄▄ █ █▀▀ █▀█ ██▄ █▀▄");

            case "main-menu":
                System.out.println("\n" + //
                                        "█▀▀ ▄▄ █▀▀ █ █▀█ █░█ █▀▀ █▀█\n" + //
                                        "██▄ ░░ █▄▄ █ █▀▀ █▀█ ██▄ █▀▄");
                break;

            default:
                break;
        }
        System.out.println("--------------------------------------------------");
    }

    /*
    Prompt the user to hit enter to continue.
    */
   public static void promptEnter() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

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
                System.out.println("Select an action.\n\t1. Encode a message\n\t2. Decode a message\n\t3. Change the current key\n\t4. Generate a random key\n\t5. Return to main menu\n");
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

            case "unlabelled-true-false":
                System.out.print("\t1. True\n\t2. False\n");
				return scanner.nextLine();

            default:
                System.out.println("UI Not Found");
                throw new IllegalArgumentException("No UI with ID: " + id);
        }
    }

    public static void runCaesarCipher() {
        clearScreen("caesar-cipher");
        
        String key = getUserRequest("input-cipherKey");
        
        try {
            Integer.parseInt(key);
        } catch (NumberFormatException e) {
            System.out.println("Invalid key. Key must be an integer.");
            promptEnter();
            return;
        }

        Cipherable caesarCipher = new CaesarCipher(Integer.parseInt(key));

        String message = "";

        String action = "0";

        while (true) {
            clearScreen("caesar-cipher");
            
            action = getUserRequest("selection-keyed-cipherAction");

            switch (action) {
                case "1":
                    clearScreen("caesar-cipher");
                    message = getUserRequest("input-messageEncrypt");
                    String encodedMessage = caesarCipher.encode(message);
                    System.out.println("Encoded Message: " + encodedMessage);

                    promptEnter();
                    break;

                case "2":
                    clearScreen("caesar-cipher");
                    message = getUserRequest("input-messageDecrypt");
                    String decodedMessage = caesarCipher.decode(message);
                    System.out.println("Decoded Message: " + decodedMessage);

                    promptEnter();
                    break;

                case "3":
                    clearScreen("caesar-cipher");
                    key = getUserRequest("input-cipherKey");
                    caesarCipher = new CaesarCipher(Integer.parseInt(key));
                    System.out.println("Key successfully updated.");

                    promptEnter();
                    break;

                //todo implement random key generation
                case "4":
                    clearScreen("caesar-cipher");

                    int newKey = CaesarCipher.generateRandomKey();

                    caesarCipher = new CaesarCipher(newKey);
                    System.out.println("Key successfully updated to " + newKey);

                    promptEnter();
                    break;

                case "5":
                    break;

                default:
                    System.out.println("Invalid, please pick a valid option.");
            }

            if (action.equals("5")) {
                break;
            }
        }
    }

    public static void runSubstitutionCipher() {
        // todo user 

        clearScreen("substitution-cipher");
        String key = getUserRequest("input-cipherKey");
        
        Cipherable substitutionCipher = new SubstitutionCipher(key);

        promptEnter();

        String message = "";

        String action = "0";

        while (true) {
            clearScreen("substitution-cipher");
            
            action = getUserRequest("selection-keyed-cipherAction");

            switch (action) {
                case "1":
                    clearScreen("substitution-cipher");
                    message = getUserRequest("input-messageEncrypt");
                    String encodedMessage = substitutionCipher.encode(message);
                    System.out.println("Encoded Message: " + encodedMessage);

                    promptEnter();
                    break;

                case "2":
                    clearScreen("substitution-cipher");
                    message = getUserRequest("input-messageDecrypt");
                    String decodedMessage = substitutionCipher.decode(message);
                    System.out.println("Decoded Message: " + decodedMessage);

                    promptEnter();
                    break;

                case "3":
                    clearScreen("substitution-cipher");
                    key = getUserRequest("input-cipherKey");
                    substitutionCipher = new SubstitutionCipher(key);
                    System.out.println("Key successfully updated.");

                    promptEnter();
                    break;

                //todo implement random key generation
                case "4":
                    clearScreen("substitution-cipher");
                    
                    String newKey = SubstitutionCipher.generateRandomKey();

                    substitutionCipher = new SubstitutionCipher(newKey);
                    System.out.println("Key successfully updated to " + newKey);

                    promptEnter();
                    break;

                case "5":
                    break;

                default:
                    System.out.println("Invalid, please pick a valid option.");
            }

            if (action.equals("5")) {
                break;
            }
        }
    }

    public static void runPairShiftCipher() {
        clearScreen("pairshift-cipher");
        System.out.println("Use uppercase letters?");
        String response = getUserRequest("unlabelled-true-false");
        
        Cipherable pairshiftCipher;
        
        if (response.equals("1")) {
            pairshiftCipher = new PairShiftCipher(true);
        } else {
            pairshiftCipher = new PairShiftCipher(false);
        }
        

        String message = "";

        String action = "0";

        while (true) {
            clearScreen("pairshift-cipher");
            
            action = getUserRequest("selection-unkeyed-cipherAction");

            switch (action) {
                case "1":
                    clearScreen("pairshift-cipher");
                    message = getUserRequest("input-messageEncrypt");
                    String encodedMessage = pairshiftCipher.encode(message);
                    System.out.println("Encoded Message: " + encodedMessage);

                    promptEnter();
                    break;

                case "2":
                    clearScreen("pairshift-cipher");
                    message = getUserRequest("input-messageDecrypt");
                    String decodedMessage = pairshiftCipher.decode(message);
                    System.out.println("Decoded Message: " + decodedMessage);

                    promptEnter();
                    break;

                case "3":
                    break;

                default:
                    System.out.println();
            }

            if (action.equals("3")) {
                break;
            }
        }
    }


	public static void main(String[] args) {
        while (true) {
            clearScreen("main-menu");
            String cipherChoice = getUserRequest("selection-cipherType");

            switch (cipherChoice) {
                case "1":
                    runCaesarCipher();
                    break;

                case "2":
                    runSubstitutionCipher();
                    break;

                case "3":
                    runPairShiftCipher();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}