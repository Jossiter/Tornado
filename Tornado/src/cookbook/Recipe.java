package cookbook;

import java.util.Comparator;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

public class Recipe implements Comparator<Recipe>, Comparable<Recipe> {
	private Resource input = null;
	private Action action = null;
	private Resource output = null;
	
	// Constructors
	public Recipe (Resource input,
					Action action,
					Resource output
			) {
		setInput (input);
		setOutput (output);
		setAction (action);
	}
	
    // Overriding the compareTo method
	public int compareTo(Recipe r) {
		return (this.read()).compareTo(r.read());
	}

	@Override
	public int compare(Recipe r1, Recipe r2) {
		// TODO Auto-generated method stub
		return (r1.read()).compareTo(r2.read());
	}	

	
	// Get Methods
	public String read () {
		return action.getName() 
				+ " " 
				+ input.getName()
				+ " = "
				+ output.getName();
	}
	
	public Document document () {
    	Document document = new Document();
    	document.add(new TextField("action", action.getName() , Field.Store.YES));
    	document.add(new TextField("resource", input.getName() , Field.Store.YES));
       	document.add(new TextField("output", output.getName() , Field.Store.YES));
    	return document;		
	}
	
	
	// Set Methods
	private void setInput (Resource r) {
		this.input = r;
	}
	private void setOutput (Resource r) {
		this.output = r;
	}
	private void setAction (Action a) {
		this.action = a;
	}

}
