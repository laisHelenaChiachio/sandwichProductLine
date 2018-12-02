package sandwich.shared;

public enum Feature {
	Sandwich(10, Category.SANDWICH),
	Drink(20, Category.DRINK),
	Additional(30, Category.ADDITIONAL),
	SandwichSteps(11, Category.SANDWICH),
	DrinkSteps(21, Category.DRINK),
	AdditionalSteps(31, Category.ADDITIONAL);

	private final int val;
	private final Category category;

	private Feature(int val, Category category) {
		this.val = val;
		this.category = category;
	}

	public boolean isProduct() { return val%2 == 0; }
	public boolean isProductLine() { return !isProduct(); }

	public boolean isCategory(Category category) { return this.category == category; }
}
