package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import games.NumberGuessingGame;
import games.WordGuessingGame;

public class Pet {
	private String name;
	private int healthPoints;
	private int hungerPoints;
	private int joyPoints;
	private boolean dead;
	
	Scanner sc = new Scanner(System.in);
	
	Bag bag = new Bag();
	
	public Pet() {
		this.healthPoints = 10;
		this.hungerPoints = 7;
		this.joyPoints = (int) (Math.random()*7 + 1);
		this.dead = false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getHungerPoints() {
		return hungerPoints;
	}
	public void setHungerPoints(int hungerPoints) {
		this.hungerPoints = hungerPoints;
	}
	public int getJoyPoints() {
		return joyPoints;
	}
	public void setJoyPoints(int joyPoints) {
		this.joyPoints = joyPoints;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public void showPet() {
		System.out.println("             ,\\\r\n"
				+ "             \\\\\\,_\r\n"
				+ "              \\` ,\\\r\n"
				+ "         __,.-\" =__)\r\n"
				+ "       .\"        )\r\n"
				+ "    ,_/   ,    \\/\\_\r\n"
				+ "    \\_|    )_-\\ \\_-`\r\n"
				+ "       `-----` `--`");
	}
	
	public void showStatusBar(int statusBar) {
		for (int i = 0; i < statusBar; i++) {
			System.out.print("#");
		}
	}
	
	public int feed() {
		
		if (this.joyPoints == 1) {
			System.out.println("You cant eat anymore, not enough Joy energy");
			return 0;
		}
		
		if (this.hungerPoints == 10) {
			System.out.println("You cant eat anymore, is full of Hunger energy");
			return 0;
		}
		
		System.out.println("A carrot for " + this.name);
		System.out.println("    _\\/_\r\n"
				+ "    \\  /\r\n"
				+ "     \\/");
		
		this.joyPoints = this.joyPoints -1;
		
		addPoints('h', true, false);
		return  2;
	}
	
	public int play() {
		
		if(this.hungerPoints == 1) {
			System.out.println("You cant play anymore, not enough Hunger energy");
			return 0;
		}
		
		if(this.joyPoints == 10) {
			System.out.println("You cant play anymore, is full of Joy energy");
			return 0;
		}
			
		int gameSeletion = (int)(Math.random()*4 +1);
		boolean win = false;
		boolean specialRound = (int) (Math.random()*10+1) == 7 ? true : false;
		
		
		switch(gameSeletion) {
			case 1:
				win = NumberGuessingGame.run();
				break;
			case 2:
				win = WordGuessingGame.run();
				break;
			case 3:
				System.out.println("Playing with " + this.name);
				System.out.println("		    __\r\n"
						+ "		 .'\".'\"'.\r\n"
						+ "		:._.\"\"._.:\r\n"
						+ "		:  \\__/  :\r\n"
						+ "		 './  \\.'\r\n"
						+ "		    \"\"");
				
				win = true;
				break;
			case 4: 
				System.out.println(this.name + " dont want to play right now");
		}
		
		bag.setMoney(win ? bag.getMoney() + 50 : bag.getMoney());
		
		this.hungerPoints = this.hungerPoints -1;
		addPoints('j', win, specialRound);
		return  2;
	}

	private void addPoints(char typeOfPoints, boolean win, boolean specialRound) {
		int points = specialRound ? 3 : 2;
		
		if(typeOfPoints == 'h' && this.hungerPoints < 10)
				this.hungerPoints += 1;
		else if (typeOfPoints == 'j' && win && this.joyPoints < 10)
				this.joyPoints = this.joyPoints + points > 10 ? 10 : this.joyPoints + points;
	}
	
	public void checkPetHealth() {
		if(this.joyPoints < 5) {
			this.healthPoints--;
		}
		if(this.hungerPoints < 5) {
			this.healthPoints--;
		}
		if(this.healthPoints <= 0) {
			this.dead = true;
			System.out.println("     .-.\r\n"
					+ "   __| |__\r\n"
					+ "  [__   __]\r\n"
					+ "     | |\r\n"
					+ "     | |\r\n"
					+ "     | |\r\n"
					+ "     '-'");
			System.out.println(this.name + " died!");
			System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		}
	}

	public String buyPotions() {
		if(this.bag.getMoney() < this.bag.FEED_POTIONS_PRICE)
			return "You have not enough money to buy this products";
		
		int potionOption = 0;
		int potionQuantity = 1;
		
		System.out.println("1. Feed potion\t\t\t2. Health potions");
		System.out.print("What do you want to buy: ");
		
		try {
			potionOption = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return "Something went wrong!!!\nExiting...";
		}
		
		System.out.print("How many potions you want: ");
		
		try {
			potionQuantity = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return "Something went wrong!!!\nExiting...";
		}
		
		if (potionQuantity == 0) {
			return "You cannot buy 0 potions";
		}
		
		System.out.print("Are you sure [Y/n]");
		String confirmOption = sc.nextLine().trim().toLowerCase();
		if (!confirmOption.equals("") && !confirmOption.equals("y")) {
			return "Exiting...";
		}
		
		if(potionOption == 1 && this.bag.getMoney() >= this.bag.FEED_POTIONS_PRICE*potionQuantity) {
			this.bag.setFeedPotions(this.bag.getFeedPotions() + potionQuantity);
			this.bag.setMoney(this.bag.getMoney() - this.bag.FEED_POTIONS_PRICE*potionQuantity);
			return "Done succesfully, your feed potions now are: " + this.bag.getFeedPotions();
		}
			
		if(potionOption == 2 && this.bag.getMoney() >= this.bag.HEALTH_POTIONS_PRICE*potionQuantity) {
			this.bag.setHealthPotions(this.bag.getHealthPotions() + potionQuantity);
			this.bag.setMoney(this.bag.getMoney() - this.bag.HEALTH_POTIONS_PRICE*potionQuantity);
			return "Done succesfully, your health potions now are: " + this.bag.getHealthPotions();
		}
		
		return "Something went wrong!!!";
	}

	public String usePotions() {
		if(this.bag.getHealthPotions() == 0 && this.bag.getFeedPotions() == 0)
			return "You have no potions to use";
		
		int potionOption = 0;
		int potionQuantity = 1;
		
		System.out.println("1. Feed potion\t\t\t2. Health potions");
		System.out.print("Which one you want to use: ");
		
		try {
			potionOption = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return "Something went wrong!!!\nExiting...";
		}
		
		System.out.println("How much potions you want to use");
		
		try {
			potionQuantity = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return "Something went wrong!!!\nExiting...";
		}
		
		if (potionQuantity == 0) {
			return "You cannot use 0 potions";
		}else if (this.bag.getFeedPotions() < potionQuantity) {
			return "you cannot use more potions than what you have in the bag";
		}
		
		System.out.print("Are you sure [Y/n]");
		String confirmOption = sc.nextLine().trim().toLowerCase();
		if (!confirmOption.equals("") && !confirmOption.equals("y")) {
			return "Exiting...";
		}
		
		if(potionOption == 1 && this.bag.getFeedPotions() >= 1) {
			if(this.hungerPoints + potionQuantity * 2 > 10) {
				return "ERROR!!!\nCannot use, full feed passed!!!";
			}
			this.setHungerPoints(this.hungerPoints + potionQuantity * 2);
			this.bag.setFeedPotions(this.bag.getFeedPotions() - potionQuantity);
			return "Done succesfully, your feed potions now are: " + this.bag.getFeedPotions();
		}
			
		if(potionOption == 2 && this.bag.getHealthPotions() >= 1) {
			if(this.healthPoints + potionQuantity * 2 > 10) {
				return "ERROR!!!\nCannot use, full feed passed!!!";
			}
			this.setHealthPoints(this.healthPoints + potionQuantity * 2);
			this.bag.setHealthPotions(this.bag.getHealthPotions() - potionQuantity);
			return "Done succesfully, your health potions now are: " + this.bag.getFeedPotions();
		}
		
		return "Something went wrong!!!";
	}
}
