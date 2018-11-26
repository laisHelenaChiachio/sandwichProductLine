package sandwichProductLine.code;

public class Additional extends Product {
	
	int quantity;
	
	Additional(String additionalName, String additionalDescription, float additionalPrice, int quantity) {
		super(additionalName, additionalDescription, additionalPrice, Category.ADDITIONAL);
		this.quantity = quantity;
	}
	

	Additional(String additionalName, String additionalDescription, float additionalPrice) {
		super(additionalName, additionalDescription, additionalPrice, Category.ADDITIONAL);
		this.quantity = 1;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getAdditioalName() {
		return super.productName;
	}

	public void setAdditioalName(String additionalName) {
		super.setProductName(additionalName);
	}
	
	public String getAdditioalDescription() {
		return super.getProductDescription();
	}

	public void setAdditioalDescription(String additionalDescription) {
		super.setProductDescription(additionalDescription);
	}
	
	public float getAdditioalPrice() {
		return super.productPrice;
	}

	public void setAdditioalPrice(float additionalPrice) {
		super.setProductPrice(additionalPrice);
	}
}
