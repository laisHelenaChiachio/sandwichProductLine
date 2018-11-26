package sandwichProductLine.code;

public class Sandwich extends Product{
	
int quantity;
	
	Sandwich(String sandwichName, String sandwichDescription, float sandwichPrice, int quantity) {
		super(sandwichName, sandwichDescription, sandwichPrice, Category.SANDWICH);
		this.quantity = quantity;
	}
	

	Sandwich(String sandwichName, String sandwichDescription, float sandwichPrice) {
		super(sandwichName, sandwichDescription, sandwichPrice, Category.SANDWICH);
		this.quantity = 1;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
