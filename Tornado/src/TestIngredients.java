import java.io.IOException;

import org.apache.lucene.search.TopDocs;

import cookbook.Action;
import cookbook.Cookbook;
import cookbook.Ingredient;
import cookbook.IngredientList;
import cookbook.Recipe;
import cookbook.Resource;

public class TestIngredients {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Action a = new Action("Cook");
		IngredientList i = new IngredientList();
		IngredientList o = new IngredientList();		

		Resource water = new Resource("Water");
		i.add(new Ingredient("Flour"));
		i.add(new Ingredient("Eggs", 2));	
		i.add(new Ingredient(water, 3));		
		
		o.add(new Ingredient("Cake"));
		
		Recipe recipe1 = new Recipe(a, i, o);
		
		a = new Action("Stir");
		i = new IngredientList();
		o = new IngredientList();
		
		i.add(new Ingredient(water));
		i.add(new Ingredient("Beef"));
		o.add(new Ingredient("Gravy"));
		
		Recipe recipe2 = new Recipe(a, i, o);
		
		System.out.println(recipe1.printFull());
		System.out.println(recipe2.printFull());
		System.out.println();
		System.out.println(recipe1.print());
		System.out.println(recipe2.print());
	}

}

