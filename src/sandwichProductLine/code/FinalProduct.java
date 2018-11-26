package sandwichProductLine.code;

import java.util.ArrayList;

public class FinalProduct {
	
	ArrayList<String> mainProducts = new ArrayList<String>();	
	ArrayList<String> productLine = new ArrayList<String>();
	
	public FinalProduct(ArrayList<String> mainProductsList){
		mainProducts.addAll(mainProductsList);
	}
	
	public void ProductLine(ArrayList<String> productLine){
		this.productLine.addAll(productLine);
	}
		
	public void setMainProducts(Category category) {
		mainProducts.add(CategoryNames.getWichCategory(category));
	}
	
	public void setProductLine(Category category) {
		productLine.add(CategoryNames.getWichCategory(category));
	}
	
	
	public int getMainProductListSize() {
		return mainProducts.size();
	}
	
	public int getProductLineListSize() {
		return productLine.size();
	}
	
	
	public ArrayList<String> getMainProducts() {
		return mainProducts;
	}
	
	public boolean getProductWasSelected(Category category) {
		if (mainProducts.contains(CategoryNames.getWichCategory(category))) 
		    return true;
		 else 
		   return false;
	}
	
	public boolean setProductLineOptions(Category category) {
		if (mainProducts.contains(CategoryNames.getWichCategory(category))) 
		    return true;
		 else 
		   return false;
	}
}
