package sandwich.shared;

import sandwich.shared.Category;

public class CategoryNames {
	
	public static String getWichCategory(Category c) {
		switch(c) {
		case SANDWICH:
			return "Sanduíche";
		case DRINK:
			return "Bebida";
		case ADDITIONAL:
			return "Adicionais";
		default:
			return null;
		}
	}

}
