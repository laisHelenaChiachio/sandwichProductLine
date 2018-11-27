package sandwichProductLine.code;

import java.util.ArrayList;

public class Product {

	String productName;
	String productDescription;
	float productPrice;
	Category category;
	
	ArrayList<String> productFields = new ArrayList<String>();	

	
	Product(String productName, String productDescription, float productPrice, Category category){
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.category = category;
		productFields.add("Nome");
		productFields.add("Descrição");
		productFields.add("Preço");
	}
	
	Product(){}
	
	public String getProductName() {
		return productName;
	}
	
	public ArrayList<String> getProductFields() {
		return productFields;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
