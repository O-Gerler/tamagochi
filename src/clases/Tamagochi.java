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

		int time = 8;
		int day = 0;
		
		int option;

		do {
			
			option = showPetStatsAndSelectOption(sc, pet, FEED, PLAY, SLEEP, EXIT);

			switch (option) {
			case FEED:
				time = pet.feed() == 2 ? time + 2 : time;
				break;
			case PLAY:
				time = pet.play() == 2 ? time + 2 : time;
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

	private int showPetStatsAndSelectOption(Scanner sc, Pet pet, final int FEED, final int PLAY, final int SLEEP,
			final int EXIT) {
		int option = -1;
		pet.showPet();
		System.out.print("Health:\t");
		pet.showStatusBar(pet.getHealthPoints());
		System.out.print("\nHunger:\t");
		pet.showStatusBar(pet.getHungerPoints());
		System.out.print("\nJoy:\t");
		pet.showStatusBar(pet.getJoyPoints());
		System.out.println("\nWhat you wanna do");
		System.out.println(FEED + ". FEED\t\t" + PLAY + ". PLAY\t\t" + SLEEP + ". SLEEP\t" + EXIT + ". EXIT");
		System.out.println("Select the option: ");
		try {
			option = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Select a correct option!");
			option = -1;
		}
		
		return option;
	}

	private void setPetName(Scanner sc, Pet pet) {
		System.out.println("Choose the name for your new Pet");
		pet.showPet();
		System.out.print("The name is: ");
		pet.setName(sc.nextLine());
	}
	
}
