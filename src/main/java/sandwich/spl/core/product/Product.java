package sandwich.spl.core.product;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import sandwich.shared.Category;

public class Product {

	protected String productName;
	protected String productDescription;
	protected float productPrice;
	protected Category category;

	protected ArrayList<String> productFields = new ArrayList<String>();

	
	protected Product(String productName, String productDescription, float productPrice, Category category){
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.category = category;
		productFields.add("Nome");
		productFields.add("Descrição");
		productFields.add("Preço");
	}

	protected Product(){}
	
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
