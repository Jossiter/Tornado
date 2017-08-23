package cookbook;

import java.util.Comparator;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

public class Recipe implements Comparator<Recipe>, Comparable<Recipe> {
	
	private Action action = null;
	private IngredientList input, output = null;
	
	// Constructors
	public Recipe (Action action,
					IngredientList input,
					IngredientList output
			) {
		setInput (input);
		setOutput (output);
		setAction (action);
	}
	
    // Overriding the compareTo method
	public int compareTo(Recipe r) {
		return (this.print()).compareTo(r.print());
	}

	@Override
	public int compare(Recipe r1, Recipe r2) {
		// TODO Auto-generated method stub
		return (r1.print()).compareTo(r2.print());
	}	

	
	// Get Methods
	public Document document () {
    	Document document = new Document();
    	document.add(new TextField("action", action.print() , Field.Store.YES));
    	document.add(new TextField("input", input.print() , Field.Store.YES));
       	document.add(new TextField("output", output.print() , Field.Store.YES));
    	return document;		
	}
	
	
	// Set Methods
	private void setAction (Action a) {
		this.action = a;
	}
	private void setInput (IngredientList i) {
		this.input = i;
	}
	private void setOutput (IngredientList i) {
		this.output = i;
	}

	// Output methods
	public String print () {
		return action.print() 
				+ " : " 
				+ input.print()
				+ " = "
				+ output.print();
	}	
}
