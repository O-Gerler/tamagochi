package clases;

import java.util.Scanner;

public class Pet {
	private String name;
	private int healthPoints;
	private int hungerPoints;
	private int joyPoints;
	private boolean dead;
	
	Scanner sc = new Scanner(System.in);
	
	public Pet() {
		this.healthPoints = 10;
		this.hungerPoints = (int) (Math.random()*10 + 1);
		this.joyPoints = (int) (Math.random()*10 + 1);
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
		
		if(this.joyPoints == 0)
			return 2;
		
		System.out.println("A carrot for " + this.name);
		System.out.println("    _\\/_\r\n"
				+ "    \\  /\r\n"
				+ "     \\/");
		
		this.joyPoints = this.joyPoints -1;
		
		System.out.print("Press enter...");
		sc.nextLine();
		
		return addPoints(this.hungerPoints, 'h') ? 2 : 0;
	}
	
	public int play() {
		
		if(this.hungerPoints == 0)
			return 2;
		
		System.out.println("Playing with " + this.name);
		System.out.println("		    __\r\n"
				+ "		 .'\".'\"'.\r\n"
				+ "		:._.\"\"._.:\r\n"
				+ "		:  \\__/  :\r\n"
				+ "		 './  \\.'\r\n"
				+ "		    \"\"");
		
		this.hungerPoints = this.hungerPoints -1;
		
		System.out.print("Press enter...");
		sc.nextLine();
		
		return addPoints(this.joyPoints, 'p') ? 2 : 0;
	}

	private boolean addPoints(int points, char typeOfPoints) {
		if(typeOfPoints == 'h') {
			if (this.hungerPoints < 10) {
				this.hungerPoints = this.hungerPoints + 1;
				return true;
			}
			return false;
		} else {
			if (this.joyPoints < 10) {
				this.joyPoints = this.joyPoints + 1;
				return true;
			}
			return false;
		}
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
			System.out.println(this.name + " died!");
		}
	}
}
