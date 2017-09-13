package cookbook;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class IngredientList implements Comparator<IngredientList>, Comparable<IngredientList>{
	private TreeSet<Ingredient> ingredients;
	
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
	
	// Add & Remove methods
	public boolean add (Ingredient ingredient) {
		if (ingredient.getQty() < 1) {
			return false;
		} else {
			return ingredients.add(ingredient);
		}
	}
	
	protected boolean remove (Ingredient ingredient) {
		return ingredients.remove(ingredient);
	}	
	
	protected boolean increase (Ingredient ingredient) {
		boolean ret = add(ingredient);
		
		if (ret != true ) {
			Ingredient in = find (ingredient);
			ret = true;
			
			if (in != null) {
				int qty = in.getQty() + ingredient.getQty();
				in.setQty(qty);
			} else {
				ret = false;
			}
		}
		
		return ret;
	}
	
	protected boolean decrease (Ingredient ingredient) {
		boolean ret = true;
		Ingredient in = find (ingredient);
		
		if (in != null) {
			int qty = in.getQty() - ingredient.getQty();
			
			if (qty < 1) {
				ret = ingredients.remove(in);
			} else {
				in.setQty(qty);
			}
		} else {
			ret = false;
		}
		
		return ret;
	}
	
	// Query methods
	public TreeSet<Ingredient> getIngredients () {
		return ingredients;
	}
	
	public int qty () {
		Iterator<Ingredient> i = ingredients.iterator();
		
		// Add up the quantities
		int qty = 0;		
		while (i.hasNext()) {
			qty += i.next().getQty();
		}
		
		return qty;
	}	
	
	public Ingredient find (Resource resource) {
		Iterator<Ingredient> i = ingredients.iterator();
		Ingredient in, ret = null;
		int result;
		
		while (i.hasNext()) {
		    in = (Ingredient) i.next();
		    result = in.compareTo(resource);
			if (result == 0) {
				ret = in;
				break;
			} else if (result > 0) {
				ret = null;
				break;
			}
		}		
		
		return ret; 
	}
	
	// Emptying the bag
	protected void clear () {
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
