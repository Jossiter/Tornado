package cookbook;

public class IngredientBag {
	IngredientList ingredients;
	
	public IngredientBag () {
		ingredients = new IngredientList();
	}

	//add methods
	public boolean add (Resource resource, int qty) {
		return add(new Ingredient(resource, qty));
	}
	public boolean add (Resource resource) {
		return add(new Ingredient(resource, 1));
	}
	public boolean add (Ingredient ingredient) {
		return ingredients.increase(ingredient);
	}	
	
	// remove methods
	public boolean remove (Resource resource, int qty) {
		return remove(new Ingredient(resource, qty));
	}
	public boolean remove (Ingredient ingredient) {
		return ingredients.decrease(ingredient);
	}
	public boolean remove (Resource resource) {
		return ingredients.remove(new Ingredient(resource));		
	}
	
	
	// Queries
	public int qty() {
		return ingredients.qty();
	}
	
	// Clear the bag
	public void clear () {
		ingredients.clear();
	}
	
	// Print the bag contents
	public String print () {
		return ingredients.printQuantities();
	}
}
