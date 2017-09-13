package cookbook;

import java.util.Comparator;

public class Recipe implements Comparator<Recipe>, Comparable<Recipe> {
	
	private Action action = null;
	private IngredientList input, output = null;
	
	// Constructors
	public Recipe (Action action,
					IngredientList input,
					IngredientList output
			) {
		setInput (input);
		setOutput (output);
		setAction (action);
	}
	
    // Overriding the compareTo method
	public int compareTo(Recipe r) {
		// -1 means not the same
		// 0 means identical 
		// +1 means similar (different qty or partial match)
		// check actions are the same
		
		int ret = this.action.compareTo(r.action);
		
		if (ret == 0) {
			ret = (this.print()).compareTo(r.print());
		} else {
			ret = -1;
		}
		
		return ret;
	}

	@Override
	public int compare(Recipe r1, Recipe r2) {
		// TODO Auto-generated method stub
		return (r1.print()).compareTo(r2.print());
	}

	// Query Methods
	// Does this recipe contain this resource?
	public boolean testResource (Resource resource) {
		
		
		return true;
	}
	
	// Get Methods
	public IngredientList getInput () {
		return input;
	}
	public IngredientList getOutput () {
		return output;
	}
	public Action getAction () {
		return action;
	}
	
	// Set Methods
	private void setAction (Action a) {
		this.action = a;
	}
	private void setInput (IngredientList i) {
		this.input = i;
	}
	private void setOutput (IngredientList i) {
		this.output = i;
	}

	// Output methods
	public String print () {
		return action.print() 
				+ " " 
				+ input.print();

	}
	public String printFull () {
		return action.print() 
				+ " : " 
				+ input.printQuantities()
				+ " = "
				+ output.printQuantities();
	}
}
