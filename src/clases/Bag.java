package clases;

public class Bag {
	private int money;
	private int healthPotions;
	private int feedPotions;
	
	final int HEALTH_POTIONS_PRICE = 1000;
	final int FEED_POTIONS_PRICE = 200;
	
	public Bag() {
		this.money = 500;
		this.healthPotions = 0;
		this.feedPotions = 0;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getHealthPotions() {
		return healthPotions;
	}
	public void setHealthPotions(int healthPotions) {
		this.healthPotions = healthPotions;
	}
	public int getFeedPotions() {
		return feedPotions;
	}
	public void setFeedPotions(int feedPotions) {
		this.feedPotions = feedPotions;
	}

	public int getHEALTH_POTIONS_PRICE() {
		return HEALTH_POTIONS_PRICE;
	}

	public int getFEED_POTIONS_PRICE() {
		return FEED_POTIONS_PRICE;
	}
	
	public void buyHealthPotions() {
		if (this.money > HEALTH_POTIONS_PRICE) {
			this.healthPotions++;
			this.money -= HEALTH_POTIONS_PRICE;
		}
	}
	
	public void buyFeedPotions() {
		if (this.money > FEED_POTIONS_PRICE) {
			this.healthPotions++;
			this.money -= FEED_POTIONS_PRICE;
		}
	}
}
