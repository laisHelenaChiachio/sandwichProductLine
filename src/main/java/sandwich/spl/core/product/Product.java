package sandwich.spl.core.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Product implements IProduct {

	private String name;
	private String description;
	private float price;
	private List<IProductItem> subItems = new ArrayList<>();

	public Product(String name, String description, float price){
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public String getName() { return name; }
	@Override
	public void setName(String name) { this.name = name; }

	@Override
	public String getDescription() { return description; }
	@Override
	public void setDescription(String description) { this.description = description; }

	@Override
	public float getPrice() { return price; }
	@Override
	public void setPrice(float price) {this.price = price; }

	@Override
	public List<IProductItem> getSubItems() { return subItems; }

	@Deprecated // TODO: Remove this method later
	public static String[] productFields = {"Nome", "Descrição", "Preço"};
	@Deprecated // TODO: Remove this method later
	public ArrayList<String> getProductFields(){ return new ArrayList<>(Arrays.asList(productFields)); }
}
