package sandwich.spl.core.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sandwich.shared.Category;
import sandwich.spl.core.product.step.IProductManufactureStep;
import sandwich.spl.core.product.step.ProductManufactureStep;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product implements IProduct {

	private String name;
	private String description;
	private float price;
	private Category category;
	@JsonDeserialize(contentAs = ProductManufactureStep.class)
	private List<IProductManufactureStep> steps = new ArrayList<>();

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
	public Category getCategory() { return category; }
	protected void setCategory(Category category) { this.category = category; }

	@Override
	public List<IProductManufactureStep> getSteps() { return steps; }
	public void setSteps(List<IProductManufactureStep> steps) { this.steps = steps; }


	public IProduct castToTrueType()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		String name = getCategory().toString().toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		Product trueTyped = null;
		Class c;
		try {
			c = Class.forName("sandwich.spl.core.product." + name);
		} catch (ClassNotFoundException ignored) {
			try {
				c = Class.forName("sandwich.spl.variants.product." + name);
			} catch (ClassNotFoundException ignored2) {
				try {
					c = Class.forName("sandwich.spl.variants.product.step" + name);
				} catch (ClassNotFoundException ignored3) {
					return null;
				}
			}
		}

		List<IProductManufactureStep> steps = getSteps().stream()
				.map(s -> {
					try {
						return IProductManufactureStep.castToTrueType(s, getCategory());
					} catch (Exception e) {
						return ProductManufactureStep.Invalid;
					}
				})
				.collect(Collectors.toList());
		if (steps.contains(ProductManufactureStep.Invalid)) {
			return null;
		}
		Constructor ctr = c.getConstructor(String.class, String.class, float.class);
		trueTyped = (Product) ctr.newInstance(this.name, description, price);
		trueTyped.setSteps(steps);
		return trueTyped;
	}


	@JsonIgnore
	@Deprecated // TODO: Remove this method later
	public static String[] productFields = {"Nome", "Descrição", "Preço"};
	@Deprecated // TODO: Remove this method later
	public ArrayList<String> getProductFields(){ return new ArrayList<>(Arrays.asList(productFields)); }
}
