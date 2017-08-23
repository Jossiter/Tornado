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
		return (this.print()).compareTo(o.print());
	}

	@Override
	public int compare(IngredientList o1, IngredientList o2) {
		// TODO Auto-generated method stub
		return (o1.print()).compareTo(o2.print());
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
		ingredients = null;
		ingredients = new TreeSet<Ingredient>();
	}
	
	// Output methods
	public String print () {
		// System.out.println(ingredients);
		Iterator<Ingredient> i = ingredients.iterator();
		Ingredient ingredient;
		String output = "";
		
		// Print out first item
		if (i.hasNext()) {
		    ingredient = (Ingredient) i.next();
			output = ingredient.print();
		}
		
		// Print out other items
		while (i.hasNext()) {
			ingredient = (Ingredient) i.next();
			output += " " + ingredient.print();
		}
		
		return output;
	}
}
