package games;

import java.util.Scanner;

public class NumberGuessingGame {
	public static boolean run() {
		final int CORRECT_NUMBER =(int) (Math.random()*100 +1);
		Scanner sc = new Scanner(System.in);
		int guessedNumber = 0;
		
		System.out.println("---------GUESSING-GAME---------");
		
		for (int i = 0; i < 8; i++) {
			do {
				System.out.print("Choose the number(1 - 100): ");
				try {
					guessedNumber = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.print("ERROR!!! Please insert a number: ");
					guessedNumber = 0;
				}
			} while (guessedNumber < 1 || guessedNumber > 100);
			
			if(guessedNumber == CORRECT_NUMBER) {
				System.out.println("CONGRATULATIONS!!!");
				sc.close();
				return true;
			}
			
			if(guessedNumber < CORRECT_NUMBER)
				System.out.println("The number is higher");
			else
				System.out.println("The number is lower");
		}
		
		sc.close();
		
		return false;
	}
}
