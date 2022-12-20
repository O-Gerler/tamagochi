package games;

import java.util.Scanner;

public class WordGuessingGame {
	public static boolean run() {
		Scanner sc = new Scanner(System.in);
		
		String word = askForWord(sc);
		
		return false;
	}

	private static String askForWord(Scanner sc) {
		System.out.print("Introduce a word to guess: ");
		return sc.nextLine().trim().toLowerCase();
	}
	
	
}
