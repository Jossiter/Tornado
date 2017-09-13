package cookbook;

import java.util.Comparator;

public class Action implements Comparator<Action>, Comparable<Action>{

	private String name = null;
	
	// Constructors
	public Action (String iName) {
		setName(iName);
	}
	
	// Comparators
	@Override
	public int compareTo(Action o) {
		// TODO Auto-generated method stub
		return (this.name).compareTo(o.name);
	}

	@Override
	public int compare(Action o1, Action o2) {
		// TODO Auto-generated method stub
		return (o1.name).compareTo(o2.name);
	}	
		
	// Get Methods
	public String getName () {
		return name;
	}
	
	// Put Methods
	private void setName (String iName) {
		name = new String(iName.toString());
	}
	
	// Print Methods
	public String print () {
		return name;
	}	
}
