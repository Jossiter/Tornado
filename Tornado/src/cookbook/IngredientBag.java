package cookbook;

public class IngredientBag {
	IngredientList ingredients;
	
	public IngredientBag () {
		ingredients = new IngredientList();
	}

	//add methods
	public boolean add (Resource res, int qty) {
		return add(new Ingredient(res, qty));
	}
	public boolean add (Ingredient ing) {
		return ingredients.increase(ing);
	}	
	public void clear () {
		ingredients.clear();
	}
}
