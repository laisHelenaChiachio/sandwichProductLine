package main.java.sandwich.spl.core;

import main.java.sandwich.shared.Category;

public class Drink extends Product{
	
	int quantity;
	
	Drink(String drinkName, String drinkDescription, float drinkPrice, int quantity) {
		super(drinkName, drinkDescription, drinkPrice, Category.DRINK);
		this.quantity = quantity;
	}
	

	Drink(String drinkName, String drinkDescription, float drinkPrice) {
		super(drinkName, drinkDescription, drinkPrice, Category.DRINK);
		this.quantity = 1;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDrinkName() {
		return super.productName;
	}

	public void setDrinkName(String drinkName) {
		super.setProductName(drinkName);
	}
	
	public String getDrinkDescription() {
		return super.getProductDescription();
	}

	public void setDrinkDescription(String drinkDescription) {
		super.setProductDescription(drinkDescription);
	}
	
	public float getDrinkPrice() {
		return super.productPrice;
	}

	public void setDrinkPrice(float drinkPrice) {
		super.setProductPrice(drinkPrice);
	}


}
