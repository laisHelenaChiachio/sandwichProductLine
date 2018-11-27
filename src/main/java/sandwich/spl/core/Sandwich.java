package main.java.sandwich.spl.core;

import java.util.ArrayList;
import main.java.sandwich.shared.Category;

public class Sandwich extends Product{
	
	int quantity;
	ArrayList<String> sandwichFields ;	

	
	Sandwich(String sandwichName, String sandwichDescription, float sandwichPrice, int quantity) {
		super(sandwichName, sandwichDescription, sandwichPrice, Category.SANDWICH);
		sandwichFields.addAll(super.getProductFields());
		this.quantity = quantity;
	}
	

	Sandwich(String sandwichName, String sandwichDescription, float sandwichPrice) {
		super(sandwichName, sandwichDescription, sandwichPrice, Category.SANDWICH);
		sandwichFields.addAll(super.getProductFields());
		this.quantity = 1;
	}
	
	Sandwich(){}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public ArrayList<String> getSandwichFields() {
		return sandwichFields;
	}

	public void setSandwichFields(String field) {
		if(!sandwichFields.contains(field)) {
			sandwichFields.add(field);
		}
	}
	
	public String getSandwichName() {
		return super.productName;
	}

	public void setSandwichName(String sandwichName) {
		super.setProductName(sandwichName);
	}
	
	public String getSandwichDescription() {
		return super.getProductDescription();
	}

	public void setSandwichDescription(String sandwichDescription) {
		super.setProductDescription(sandwichDescription);
	}
	
	public float getSandwichPrice() {
		return super.productPrice;
	}

	public void setSandwichPrice(float sandwichPrice) {
		super.setProductPrice(sandwichPrice);
	}

}
