package sandwichProductLine.code;

import java.util.ArrayList;

public class SandwichsOptions {
	
	ArrayList<Sandwich> sandwichOptions = new ArrayList<Sandwich>();	
	
	public SandwichsOptions(){
		sandwichOptions.add(new Sandwich("dandubaName1", "sandubaDescription1", 123));
		sandwichOptions.add(new Sandwich("dandubaName2", "sandubaDescription2", 123));
		sandwichOptions.add(new Sandwich("dandubaName3", "sandubaDescription3", 123));
		sandwichOptions.add(new Sandwich("dandubaName4", "sandubaDescription4", 123));
		sandwichOptions.add(new Sandwich("dandubaName5", "sandubaDescription5", 123));
		sandwichOptions.add(new Sandwich("dandubaName6", "sandubaDescription6", 123));
		sandwichOptions.add(new Sandwich("dandubaName7", "sandubaDescription7", 123));
	}
	
	public ArrayList<Sandwich> getSandwichOptions(){
		return sandwichOptions;
	}
		
	public void addSandwichOptions(Sandwich sandwich) {
		sandwichOptions.add(sandwich);	
	}

}
