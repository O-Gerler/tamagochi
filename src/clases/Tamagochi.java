package clases;

import java.util.Scanner;

public class Tamagochi {
	public void run() {
		Scanner sc = new Scanner(System.in);
		Pet pet = new Pet();
		setPetName(sc, pet);
		
		final int FEED = 1;
		final int PLAY = 2;
		final int SLEEP = 3;
		final int EXIT = 0;

		int time = 0;
		int day = 0;
		
		int option;

		do {
			pet.showPet();
			pet.showStatusBar(pet.getHealthPoints());
			pet.showStatusBar(pet.getHungerPoints());
			pet.showStatusBar(pet.getJoyPoints());
			System.out.println("What you wanna do");
			System.out.println(FEED + ". FEED\t" + PLAY + ". PLAY\t" + SLEEP + ". SLEEP\t" + EXIT + ". EXIT");
			System.out.println("Select the option: ");
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
			case FEED:
				System.out.println("primera opcion seleccionada\n");
				break;
			case PLAY:
				System.out.println("segunda opcion seleccionada\n");
				break;
			case SLEEP:
				System.out.println("tercera opcion seleccionada\n");
				break;
			case EXIT:
				System.out.println("ADIOS");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (option != EXIT && !pet.isDead());
		sc.close();
	}

	private void setPetName(Scanner sc, Pet pet) {
		System.out.println("Choose the name for your new Pet");
		pet.showPet();
		System.out.print("The name is: ");
		pet.setName(sc.nextLine());
	}
	
}
