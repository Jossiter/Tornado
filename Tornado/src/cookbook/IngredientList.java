package cookbook;

import java.util.SortedSet;
import java.util.TreeSet;

public class IngredientList {
	private SortedSet ingredients;
	
	// Constructors
	public IngredientList () {
		clear();
	}
	
	// Get methods
	public SortedSet getList () {
		return ingredients;
	}
	
	
	// Set methods
	public void add (Resource resource) {
		ingredients.add(resource);
	}
	public void clear () {
		ingredients = null;
		ingredients = new TreeSet();
	}
	
	// Output methods
	public void view () {
		// System.out.println(ingredients);
		Resource r = (Resource) ingredients.first();
			System.out.println(r.getName());
		}
}
