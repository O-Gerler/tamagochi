package clases;

public class Pet {
	private String name;
	private int healthPoints;
	private int hungerPoints;
	private int joyPoints;
	private boolean alive;
	
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
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void showPet() {
		System.out.println("             ,\\\r\n"
				+ "             \\\\\\,_\r\n"
				+ "              \\` ,\\\r\n"
				+ "         __,.-\" =__)\r\n"
				+ "       .\"        )\r\n"
				+ "    ,_/   ,    \\/\\_\r\n"
				+ "    \\_|    )_-\\ \\_-`\r\n"
				+ "jgs    `-----` `--`");
	}
	
}
