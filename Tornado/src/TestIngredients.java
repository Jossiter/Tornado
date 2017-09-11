import cookbook.Action;
import cookbook.Ingredient;
import cookbook.IngredientList;
import cookbook.Recipe;
import cookbook.Resource;

public class TestIngredients {

	public static void main(String[] args) {
		
		Resource water = new Resource("Water");
		Resource flour = new Resource("Flour");
		Resource eggs = new Resource("Eggs");
		Resource cake = new Resource("Cake");		
		Resource beef = new Resource("Beef");
		Resource gravy = new Resource("Gravy");
		
		Action cook = new Action("Cook");
		Action stir = new Action("Stir");
		
		IngredientList i = new IngredientList();
		IngredientList o = new IngredientList();		

		i.add(new Ingredient(flour));
		i.add(new Ingredient(eggs, 2));	
		i.add(new Ingredient(water, 3));			
		o.add(new Ingredient(cake));	
		Recipe recipe1 = new Recipe(cook, i, o);
		
		i = new IngredientList();
		o = new IngredientList();
		
		i.add(new Ingredient(water));
		i.add(new Ingredient(beef));
		o.add(new Ingredient(gravy));
		Recipe recipe2 = new Recipe(stir, i, o);	
		
		System.out.println("Printing(full) recipe 1: " + recipe1.printFull());
		System.out.println("Printing(full) recipe 2: " + recipe2.printFull());
		System.out.println();
		System.out.println("Printing(Simple) recipe 1: " + recipe1.print());
		System.out.println("Printing(Simple) recipe 2: " + recipe2.print());
		System.out.println();
	}

}

