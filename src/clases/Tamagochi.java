package clases;

import java.util.Scanner;

public class Tamagochi {
	public void run() {
		Scanner sc = new Scanner(System.in);
		Pet pet = new Pet();
		
		setPetName(sc, pet);
	}

	private void setPetName(Scanner sc, Pet pet) {
		System.out.println("Choose the name for your new Pet");
		pet.showPet();
		System.out.print("The name is: ");
		pet.setName(sc.nextLine());
	}
	
}
