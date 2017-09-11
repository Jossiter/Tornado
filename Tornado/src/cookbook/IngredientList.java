package cookbook;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class IngredientList implements Comparator<IngredientList>, Comparable<IngredientList>{
	private SortedSet<Ingredient> ingredients;
	
	// Constructors
	public IngredientList () {
		clear();
	}
	
	// Comparators 
	@Override
	public int compareTo(IngredientList o) {
		// TODO Auto-generated method stub
		return (this.printQuantities()).compareTo(o.printQuantities());
	}

	@Override
	public int compare(IngredientList o1, IngredientList o2) {
		// TODO Auto-generated method stub
		return (o1.printQuantities()).compareTo(o2.printQuantities());
	}	
	
	// Get methods
	public SortedSet<Ingredient> getIngredients () {
		return ingredients;
	}
	
	
	// Set methods
	public void add (Ingredient ingredient) {
		ingredients.add(ingredient);
	}
	public void clear () {
		ingredients = new TreeSet<Ingredient>();
	}
	
	// Output methods
	public String print () {
		
		Iterator<Ingredient> i = ingredients.iterator();
		Ingredient ingredient;
		String output = "";
		
		// Print out first item (without quantities)
		if (i.hasNext()) {
		    ingredient = (Ingredient) i.next();
			output = ingredient.print();
		}
		
		// Print out other items (without quantities)
		while (i.hasNext()) {
			ingredient = (Ingredient) i.next();
			output += " " + ingredient.print();
		}
		
		return output;
	}	
	public String printQuantities () {
		Iterator<Ingredient> i = ingredients.iterator();
		Ingredient ingredient;
		String output = "";
		
		// Print out first item (with quantities)
		if (i.hasNext()) {
		    ingredient = (Ingredient) i.next();
			output = ingredient.printQuantity();
		}
		
		// Print out other items (with quantities)
		while (i.hasNext()) {
			ingredient = (Ingredient) i.next();
			output += " " + ingredient.printQuantity();
		}
		
		return output;
	}
}
