package sandwich.spl.core.product;

import sandwich.shared.Category;

public class Sandwich extends Product implements IProduct {

	public Sandwich(String name, String description, float price) {
		super(name, description, price);
		setCategory(Category.SANDWICH);
	}
}
