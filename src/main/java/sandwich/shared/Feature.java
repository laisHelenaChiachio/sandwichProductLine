package sandwich.shared;

public enum Feature {
	Sandwich(10),
	Drink(20),
	Additional(30),
	SandwichSteps(11),
	DrinkSteps(21),
	AdditionalSteps(31);

	private final int val;

	private Feature(int val) {
		this.val = val;
	}
}
