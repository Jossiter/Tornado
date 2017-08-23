import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import cookbook.*;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Resource water = new Resource("Water");
		Resource flour = new Resource("Flour");
		
		Action a = new Action("Cook");
		IngredientList i = new IngredientList();
		IngredientList o = new IngredientList();		

		i.add(new Ingredient(flour));
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
		
		Cookbook cb = new Cookbook();
		if (cb.addRecipe(recipe1)) {
			System.out.println("Added Recipe 1 : " + recipe1.print());
		}
		if (cb.addRecipe(recipe2)) {
			System.out.println("Added Recipe 2 : " + recipe2.print());
		}
		cb.close();

		TopDocs td = cb.findResource(flour);

	}
}
