package sandwichProductLine.code;

public class Product {

	String productName;
	String productDescription;
	float productPrice;
	Category category;
	
	Product(String productName, String productDescription, float productPrice, Category category){
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.category = category;
	}
	
	public String getProductName() {
		return productName;
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
