package main.java.sandwich.shared;

import java.util.ArrayList;
import java.util.HashMap;

public class FinalProduct {
	
	ArrayList<String> mainProducts = new ArrayList<String>();	
	ArrayList<String> productLine = new ArrayList<String>();
	ArrayList<String> bread = new ArrayList<String>();
	ArrayList<String> protein = new ArrayList<String>();
	ArrayList<String> cheese = new ArrayList<String>();
	ArrayList<String> salad = new ArrayList<String>();
	ArrayList<HashMap<String, Integer>>  orderSandwichPL = new ArrayList<HashMap<String, Integer>>();
	boolean onlyReadySandwichs;
	boolean onlyPLSandwichs;


	public boolean isOnlyPLSandwichs() {
		return onlyPLSandwichs;
	}

	public void setOnlyPLSandwichs(boolean onlyPLSandwichs) {
		this.onlyPLSandwichs = onlyPLSandwichs;
	}

	public boolean isOnlyReadySandwichs() {
		return onlyReadySandwichs;
	}

	public void setOnlyReadySandwichs(boolean onlyReadySandwichs) {
		this.onlyReadySandwichs = onlyReadySandwichs;
	}

	public ArrayList<HashMap<String, Integer>> getOrderSandwichPL() {
		return orderSandwichPL;
	}

	public void setOrderSandwichPL(HashMap<String, Integer> orderSandwichPL) {
		this.orderSandwichPL.add(orderSandwichPL);
	}

	public ArrayList<String> getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread.add(bread);
	}
	

	public ArrayList<String> getCheese() {
		return cheese;
	}

	public void setSalad(String salad) {
		this.salad.add(salad);
	}
	
	public ArrayList<String> getSalad() {
		return salad;
	}

	public void setCheese(String cheese) {
		this.cheese.add(cheese);
	}
	
	public ArrayList<String> getProtein() {
		return bread;
	}

	public void setProtein(String protein) {
		this.protein.add(protein);
	}

	ArrayList<HashMap<String, String>> sandwichReadyChosen = new ArrayList<HashMap<String, String>>();
	
	
	
	public FinalProduct(ArrayList<String> mainProductsList){
		mainProducts.addAll(mainProductsList);
	}
	
	public void setProductLine(ArrayList<String> productLine){
		this.productLine.addAll(productLine);
	}
		
	public void setMainProducts(Category category) {
		mainProducts.add(CategoryNames.getWichCategory(category));
	}
	
	public void setProductLine(Category category) {
		productLine.add(CategoryNames.getWichCategory(category));
	}
	
	
	public int getMainProductListSize() {
		return mainProducts.size();
	}
	
	public int getProductLineListSize() {
		return productLine.size();
	}
	
	public ArrayList<String> getProductLine() {
		return productLine;
	}
	
	public ArrayList<HashMap<String, String>> getSandwichReadyChosen() {
		return sandwichReadyChosen;
	}
	
	public void setSandwichReadyChosen(HashMap<String, String> sandwich) {
		sandwichReadyChosen.add(sandwich);
	}
	
	public ArrayList<String> getMainProducts() {
		return mainProducts;
	}
	
	public boolean getProductWasSelected(Category category) {
		if (mainProducts.contains(CategoryNames.getWichCategory(category))) 
		    return true;
		 else 
		   return false;
	}
	
	public int getNumberOfItens() {
		int totalItens = 2;
		if(!cheese.isEmpty())
			totalItens +=1;
		if(!salad.isEmpty())
			totalItens +=1;
		return totalItens;
	}
	
	public boolean setProductLineOptions(Category category) {
		if (mainProducts.contains(CategoryNames.getWichCategory(category))) 
		    return true;
		 else 
		   return false;
	}
}
