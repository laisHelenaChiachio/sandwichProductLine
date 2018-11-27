package sandwich.spl.variants.product;

import sandwich.shared.Category;
import sandwich.spl.core.product.IProduct;
import sandwich.spl.core.product.Product;

public class Drink extends Product implements IProduct {

	public Drink(String name, String description, float price) {
		super(name, description, price);
	}

	@Override
	public Category getCategory() { return Category.DRINK; }
}
