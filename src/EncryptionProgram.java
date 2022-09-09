import java.util.*;

public class EncryptionProgram {

	// Variables
	private ArrayList<Character> list;				// Character list to encrypt
	private ArrayList<Character> shuffleList;		// Shuffled character list to encrypt
	private char character;							// To increment characters
	private char[] letters;							// Stores the message to be encrypted/decrypted
	private byte counter;							// To control the NEWKEY message
	
	// Constructor
	 EncryptionProgram() {
		list = new ArrayList<Character>();
		shuffleList = new ArrayList<Character>();
		character = ' ';
		counter = 0;
		
		NewKey();
		AskQuestion();
	}
	
	// Ask the user what he/she wants to do
	private void AskQuestion() {
		
		int response; // To store the @user response
		
		// Switch with the task to do according @user response
		while(true) {
			response = Interface.MainQuestion(counter); // @user menu
			counter++;
			
			switch (response) {
			case 1:
				//Generates a hidden key to encrypt the message
				NewKey();
				break;
			case 2:
				Encrypt();
				break;
			case 3:
				Decrypt();
				break;
			case 4:
				Quit();
				break;
			default:
				Interface.IncorrectOption();
				break;
			}
		}
	}
	// Generate a new key
	private void NewKey() {
		
		// It cleans up to generate a new key
		character = ' '; // Value 32 ASCII
		list.clear();
		shuffleList.clear();
		
		// It generates the key and the new shuffle key
		// From 32 to 127 is the ASCII range selected for this program
		for(int i = 32; i<127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		// Copy of our ArrayList "list" to "shuffleList" ArrayList
		shuffleList = new ArrayList<Character>(list);
		// It shuffles shuffleList
		Collections.shuffle(shuffleList);
		
		// Conditional to avoid sending the message when we open the application for the first time
		if (counter >= 1) {
			// Generated message
			Interface.GeneratedMessage();
		}
		counter ++;
	}
	
	// Encrypt message
	private void Encrypt() {
		
		String message;
		
		message = Interface.ReadMessage("Enter the message to be Encrypt:");
		
		letters = message.toCharArray();
		
		// Loop to store chars in "letters" array that match with "list" chars
		for(int i = 0; i<letters.length; i++) {
			
			for(int j = 0; j<list.size(); j++) {
				if(letters[i] == list.get(j)) {
					// Stores the matching index "j" value from shuffleList in "letters" array
					letters[i] = shuffleList.get(j);
					break;
				}
			}
		}
		Interface.PrintMessage(letters, "Encrypted Message:");
		
	}
	
	// Decrypt message
	private void Decrypt() {
		
		String message;
		
		message = Interface.ReadMessage("Enter the message to be Decrypt:");
		
		letters = message.toCharArray();
		
		// Loop to store chars in "letters" array that match with "list" chars
		for(int i = 0; i<letters.length; i++) {
			
			for(int j = 0; j<shuffleList.size(); j++) {
				if(letters[i] == shuffleList.get(j)) {
					// Stores the matching index "j" value from shuffleList in "letters" array
					letters[i] = list.get(j);
					break;
				}
			}
		}
		Interface.PrintMessage(letters, "Decrypted Message:");
		
	}
	
	// Quit the program
	private void Quit() {
		Interface.GoodBye();
	}
}
