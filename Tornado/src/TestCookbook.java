import java.io.IOException;

import org.apache.lucene.search.TopDocs;

import cookbook.*;

public class TestCookbook {

	public static void main(String[] args) throws IOException {
		
		ResourceFactory resourceFactory = new ResourceFactory();
		
		Resource water = resourceFactory.getResource("Water");
		Resource flour = resourceFactory.getResource("Flour");
		Resource eggs = resourceFactory.getResource("Eggs");
		Resource cake = resourceFactory.getResource("Cake");		
		Resource beef = resourceFactory.getResource("Beef");
		Resource gravy = resourceFactory.getResource("Gravy");
		Resource roastbeef = resourceFactory.getResource("Roast Beef");
		
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
		
		i = new IngredientList();
		o = new IngredientList();
		
		i.add(new Ingredient(beef));
		o.add(new Ingredient(roastbeef));
		Recipe recipe3 = new Recipe(cook, i, o);	
		
		Cookbook cb = new Cookbook();
		System.out.println("*** NEW COOKBOOK ***");
		if (cb.addRecipe(recipe2)) {
			System.out.println("Added Recipe 2 : " + recipe2.print());
		}		
		if (cb.addRecipe(recipe1)) {
			System.out.println("Added Recipe 1 : " + recipe1.print());
		}
		if (cb.addRecipe(recipe3)) {
			System.out.println("Added Recipe 3 : " + recipe3.print());
		}		

		
		cb.close();
		System.out.println("");
		System.out.println("** Searching for " + flour.print());
		Recipe[] hits = cb.findResource(flour);
		System.out.println("Total Results :: " + hits.length);
		
		for (int index = 0; index < hits.length; index++) {
			System.out.println(hits[index].print());
		}
		
		System.out.println("");
		System.out.println("** Searching for " + water.print());
		hits = cb.findResource(water);
		System.out.println("Total Results :: " + hits.length);
		
		for (int index = 0; index < hits.length; index++) {
			System.out.println(hits[index].print());
		}		
		
		System.out.println("");
		System.out.println("** Searching for " + roastbeef.print());
		hits = cb.findResource(roastbeef);
		System.out.println("Total Results :: " + hits.length);
		
		for (int index = 0; index < hits.length; index++) {
			System.out.println(hits[index].print());
		}		
		
	}
}
