package games;

import java.util.Scanner;

public class WordGuessingGame {
	public static boolean run() {
		Scanner sc = new Scanner(System.in);
		
		String word = askForWord(sc);
		String[] wordSeparated = word.split("");
		String[] emptyWord = new String[word.length()];
		fillArray(emptyWord);
		
		
		guessWordLoop(sc, wordSeparated, emptyWord);
		return !containsEmptyValue(emptyWord);
	}

	private static void fillArray(String[] emptyWord) {
		for (int i = 0; i < emptyWord.length; i++) {
			emptyWord[i] = "_";
		}
		
	}

	private static void guessWordLoop(Scanner sc, String[] wordSeparated, String[] emptyWord) {
		for (int i = 0; i < wordSeparated.length + 5 && containsEmptyValue(emptyWord); i++) {
			System.out.print("Choose a character: ");
			String guessedChar = String.valueOf(sc.nextLine().trim().toLowerCase().charAt(0));
			for (int j = 0; j < wordSeparated.length; j++) {
				if (wordSeparated[j].equals(guessedChar)) 
					emptyWord[j] = guessedChar;
			}
			showWord(emptyWord); 
		}
	}
	
	

	private static boolean containsEmptyValue(String[] emptyWord) {
		for (String string : emptyWord) {
			if(string.equals("_"))
				return true;
		}
		
		return false;
	}

	private static void showWord(String[] emptyWord) {
		for (String string : emptyWord) {
			System.out.print(string);
		}
		System.out.println();
	}

	private static String askForWord(Scanner sc) {
		System.out.print("Introduce a word to guess: ");
		return sc.nextLine().trim().toLowerCase();
	}
	
	
}
