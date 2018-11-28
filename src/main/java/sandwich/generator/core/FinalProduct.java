package sandwich.generator.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import sandwich.shared.Category;
import sandwich.shared.CategoryNames;
import sandwich.shared.Feature;
import sandwich.spl.core.product.IProduct;
import sandwich.spl.core.product.Sandwich;
import sandwich.spl.variants.product.Additional;
import sandwich.spl.variants.product.Drink;
import sandwich.spl.core.product.step.ProductItem;
import sandwich.spl.variants.product.step.SandwichStep;


@AllArgsConstructor
public class FinalProduct {

	List<String> mainProducts = new ArrayList<String>();
	List<String> productLine = new ArrayList<String>();
	List<String> bread = new ArrayList<String>();
	List<String> protein = new ArrayList<String>();
	List<String> cheese = new ArrayList<String>();
	List<String> salad = new ArrayList<String>();
	List<HashMap<String, Integer>>  orderSandwichPL = new ArrayList<HashMap<String, Integer>>();
	List<HashMap<String, String>> sandwichReadyChosen = new ArrayList<HashMap<String, String>>();
	boolean onlyReadySandwichs;
	boolean onlyPLSandwichs;

	public FinalProduct(){}

	public HashSet<Feature> features = new HashSet<>();

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

	public List<HashMap<String, Integer>> getOrderSandwichPL() {
		return orderSandwichPL;
	}

	public void addOrderSandwichPL(HashMap<String, Integer> orderSandwichPL) {
		this.orderSandwichPL.add(orderSandwichPL);
	}
	public void setOrderSandwichPL(List<HashMap<String, Integer>> orderSandwichPL) {
		this.orderSandwichPL = orderSandwichPL;
	}

	public List<String> getBread() {
		return bread;
	}

	public void addBread(String bread) {
		this.bread.add(bread);
	}
	public void setBread(List<String> bread) {
		this.bread = bread;
	}


	public List<String> getCheese() {
		return cheese;
	}

	public void addSalad(String salad) {
		this.salad.add(salad);
	}
	public void setSalad(List<String> salad) { this.salad = salad; }

	public List<String> getSalad() {
		return salad;
	}

	public void addCheese(String cheese) {
		this.cheese.add(cheese);
	}
	public void setCheese(List<String> cheese) { this.cheese = cheese; }

	public List<String> getProtein() {
		return protein;
	}
	public void addProtein(String protein) {
		this.protein.add(protein);
	}
	public void setProtein(List<String> protein) {
		this.protein = protein;
	}



	public FinalProduct(List<String> mainProductsList){
		mainProducts.addAll(mainProductsList);
	}
	
	public void setProductLine(List<String> productLine){
		this.productLine.addAll(productLine);
	}
		
//	public void setMainProducts(Category category) {
//		mainProducts.add(CategoryNames.getWichCategory(category));
//	}
//
//	public void setProductLine(Category category) {
//		productLine.add(CategoryNames.getWichCategory(category));
//	}


	public int getMainProductListSize() {
		return mainProducts.size();
	}

	public int getProductLineListSize() {
		return productLine.size();
	}
	
	public List<String> getProductLine() {
		return productLine;
	}
	
	public List<HashMap<String, String>> getSandwichReadyChosen() {
		return sandwichReadyChosen;
	}

	public void addSandwichReadyChosen(HashMap<String, String> sandwich) {
		sandwichReadyChosen.add(sandwich);
	}

	public void setSandwichReadyChosen(List<HashMap<String, String>> sandwich) {
		sandwichReadyChosen = sandwich;
	}
	
	public List<String> getMainProducts() {
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

	public void serializeToFile(File file) throws IOException {
		List<IProduct> products = new ArrayList<>();

		Random rand = new Random();

		// Ready Recipes (sandwich)
		for (HashMap<String, String> readySand : this.getSandwichReadyChosen()) {
			products.add(new Sandwich(
					readySand.keySet().toArray(new String[0])[0],
					readySand.values().toArray(new String[0])[0],
					4 + rand.nextInt(3) + rand.nextInt(9) * 0.1f));
		}

		// Make it yourself (sandwich)
		if (this.bread.size() > 0) {
			Sandwich s = new Sandwich("Custom", "Monte o seu",
					4 + rand.nextInt(3) + rand.nextInt(9) * 0.1f);
			products.add(s);

			// Bread
			SandwichStep step = new SandwichStep("Escolha o pão:", 1, 1);
			s.getSteps().add(step);
			for (String subItem : this.getBread()) {
				step.getSubItems().add(new ProductItem(subItem, "", 0));
			}

			// Protein
			step = new SandwichStep("Escolha a proteina:", 0, 1);
			s.getSteps().add(step);
			for (String subItem : this.getProtein()) {
				step.getSubItems().add(new ProductItem(subItem, "", 0));
			}

			// Cheese
			step = new SandwichStep("Escolha o queijo:", 0, 1);
			s.getSteps().add(step);
			for (String subItem : this.getCheese()) {
				step.getSubItems().add(new ProductItem(subItem, "", 0));
			}

			// Cheese
			step = new SandwichStep("Escolha a salada:", 0, 1);
			s.getSteps().add(step);
			for (String subItem : this.getSalad()) {
				step.getSubItems().add(new ProductItem(subItem, "", 0));
			}
		}

		// Mocked Drinks
		products.add(new Drink("Agua 300ml", "", 4f));
		products.add(new Drink("Suco Laranja 300ml", "", 6f));
		{
			Drink drink = new Drink("Milk Shake", "", 10f);
			products.add(drink);

			// Passo1 - Sabor
			SandwichStep step = new SandwichStep("Escolha o sorvete:", 1, 1);
			drink.getSteps().add(step);
			step.getSubItems().add(new ProductItem("Creme", "", 0));
			step.getSubItems().add(new ProductItem("Chocolate", "", 0));
			step.getSubItems().add(new ProductItem("Morango", "", 0));

			// Passo2 - Cobertura
			step = new SandwichStep("Escolha a cobertura:", 0, 1);
			drink.getSteps().add(step);
			step.getSubItems().add(new ProductItem("Chocolate", "", 0));
			step.getSubItems().add(new ProductItem("Morango", "", 0));
			step.getSubItems().add(new ProductItem("Ovomaltine", "", 0));

			// Passo3 - Cobertura Extra
			step = new SandwichStep("Cobertura Extra?:", 0, 1);
			drink.getSteps().add(step);
			step.getSubItems().add(new ProductItem("Sim", "", 2));
		}

		// Mocked Side dishes
		products.add(new Additional("Brownie", "", 8f));
		products.add(new Additional("Cookie", "", 10f));
		{
			Additional additional = new Additional("Fritas", "", 0f);
			products.add(additional);

			// Passo1 - Tamanho
			SandwichStep step = new SandwichStep("Escolha o tamanho:", 1, 1);
			additional.getSteps().add(step);
			step.getSubItems().add(new ProductItem("Pequena", "", 4));
			step.getSubItems().add(new ProductItem("Media", "", 6));
			step.getSubItems().add(new ProductItem("Grande", "", 8));
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, products);
	}
}
