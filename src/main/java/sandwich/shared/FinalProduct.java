package sandwich.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Setter;
import sandwich.spl.core.product.IProduct;


@AllArgsConstructor
public class FinalProduct {

	@JsonIgnore
	List<String> mainProducts = new ArrayList<String>();
	@JsonIgnore
	List<String> productLine = new ArrayList<String>();
	List<String> bread = new ArrayList<String>();
	List<String> protein = new ArrayList<String>();
	List<String> cheese = new ArrayList<String>();
	List<String> salad = new ArrayList<String>();
	List<HashMap<String, Integer>>  orderSandwichPL = new ArrayList<HashMap<String, Integer>>();
	List<HashMap<String, String>> sandwichReadyChosen = new ArrayList<HashMap<String, String>>();
	@JsonIgnore
	boolean onlyReadySandwichs;
	@JsonIgnore
	boolean onlyPLSandwichs;

	public FinalProduct(){}

	@JsonIgnore
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

	@JsonIgnore
	public void setOrderSandwichPL(HashMap<String, Integer> orderSandwichPL) {
		this.orderSandwichPL.add(orderSandwichPL);
	}
	public void setOrderSandwichPL(List<HashMap<String, Integer>> orderSandwichPL) {
		this.orderSandwichPL = orderSandwichPL;
	}

	public List<String> getBread() {
		return bread;
	}

	@JsonIgnore
	public void setBread(String bread) {
		this.bread.add(bread);
	}
	public void setBread(List<String> bread) {
		this.bread = bread;
	}


	public List<String> getCheese() {
		return cheese;
	}

	@JsonIgnore
	public void setSalad(String salad) {
		this.salad.add(salad);
	}
	public void setSalad(List<String> salad) { this.salad = salad; }

	public List<String> getSalad() {
		return salad;
	}

	@JsonIgnore
	public void setCheese(String cheese) {
		this.cheese.add(cheese);
	}
	public void setCheese(List<String> cheese) { this.cheese = cheese; }

	@JsonIgnore
	public List<String> getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
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


	@JsonIgnore
	public int getMainProductListSize() {
		return mainProducts.size();
	}

	@JsonIgnore
	public int getProductLineListSize() {
		return productLine.size();
	}
	
	public List<String> getProductLine() {
		return productLine;
	}
	
	public List<HashMap<String, String>> getSandwichReadyChosen() {
		return sandwichReadyChosen;
	}

	@JsonIgnore
	public void setSandwichReadyChosen(HashMap<String, String> sandwich) {
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

	@JsonIgnore
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
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, this);
	}

	public static FinalProduct deserializeFromFile(File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(file, FinalProduct.class);
	}
}
