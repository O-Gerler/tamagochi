package games;

import java.util.Scanner;

public class NumberGuessingGame {
	public static boolean run() {
		final int CORRECT_NUMBER =(int) (Math.random()*100 +1);
		Scanner sc = new Scanner(System.in);
		int guessedNumber;
		
		System.out.println("---------GUESSING-GAME---------");
		
		for (int i = 0; i < 5; i++) {
			System.out.print("Choose the number(1 - 100): ");
			guessedNumber = Integer.parseInt(sc.nextLine());
			if(guessedNumber == CORRECT_NUMBER) {
				System.out.println("CONGRATULATIONS!!!");
				return true;
			}
		}
		
		return false;
	}
}
