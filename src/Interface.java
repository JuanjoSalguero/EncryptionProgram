import java.util.*;

public class Interface {
	
	// @user Welcome and main question
		public static int MainQuestion(byte counter) {
			
			Scanner scanner = new Scanner(System.in);
			int response; // @user answer
			
			System.out.println("-----------------------------------------");
			System.out.println("Hello @user, what would you like to do?");
			if (counter <= 1) {
				System.out.println("*A key has been generated automaticly*");
			}
			System.out.println("");
			System.out.println("1. Create New Key\n2. Encrypt Message\n3. Decrypt Message\n4. Quit");
			System.out.println("-----------------------------------------");
			response = scanner.nextInt();
			
			return response;
		}
		
		// Default method to read @user method
		public static String ReadMessage(String message) {
			Scanner scanner = new Scanner(System.in);
			String response;
			
			System.out.println(message);
			response = scanner.nextLine();
			
			return response;
		}
		
		// Method to avoid system.out in the EncryptionProgram class
		// In case the @user choose a not valid answer
		public static void IncorrectOption() {
			
			System.out.println("This is not a valid answer :(");
			PressEnter();
		}
	
		// Method to send an automatic start message
		public static void GeneratedMessage() {
			
			System.out.println("*A new key has been generated*");
			PressEnter();
		}
		
		
		// Method to print encrypted and decrypted message
		public static void PrintMessage(char[] letters, String option) {
			
			System.out.println(option);
			// For-each loop to print the message
			for(char x : letters) {
				System.out.print(x);
			}
			System.out.println();
			PressEnter();
		}
		
		// Farewell message
		public static void GoodBye() {
			
			System.out.println("Thank you for using the program!\n Have a nice day. Bye :)");
			System.exit(0);
		}

		// Generic method to pause the console
		public static void PressEnter() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Press ENTER to continue...");
			scanner.nextLine();
		}
}
