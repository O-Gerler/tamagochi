package games;

import java.util.Scanner;

public class WordGuessingGame {
	public static boolean run() {
		Scanner sc = new Scanner(System.in);
		
		String word = askForWord(sc);
		String[] wordSeparated = word.split("");
		int tries = word.length();
		String[] emptyWord = new String[tries];
		fillArray(emptyWord);
		
		
		return guessWordLoop(sc, wordSeparated, tries, emptyWord);
	}

	private static void fillArray(String[] emptyWord) {
		for (int i = 0; i < emptyWord.length; i++) {
			emptyWord[i] = "_";
		}
		
	}

	private static boolean guessWordLoop(Scanner sc, String[] wordSeparated, int tries, String[] emptyWord) {
		for (int i = 0; i < wordSeparated.length && tries != 0; i++) {
			System.out.print("Choose a character: ");
			String guessedChar = sc.nextLine().trim().toLowerCase().charAt(0) + "";
			if (wordSeparated[i].equals(guessedChar)) 
				emptyWord[i].replace("_", guessedChar);
			else
				tries--;
			showWord(emptyWord);
		}
		
		return containsEmptyValue(emptyWord);
	}
	
	

	private static boolean containsEmptyValue(String[] emptyWord) {
		for (String string : emptyWord) {
			if(string.equals("_"))
				return false;
		}
		
		return true;
	}

	private static void showWord(String[] emptyWord) {
		for (String string : emptyWord) {
			System.out.print(string);
		}
		
	}

	private static String askForWord(Scanner sc) {
		System.out.print("Introduce a word to guess: ");
		return sc.nextLine().trim().toLowerCase();
	}
	
	
}
