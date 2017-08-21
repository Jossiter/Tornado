package cookbook;

import java.util.Comparator;

public class Resource implements Comparator<Resource>, Comparable<Resource> {
	private String name = null;
	
	// Constructors
	public Resource (String iName) {
		setName(iName);
	}
	
	// Comparators
	@Override
	public int compareTo(Resource o) {
		// TODO Auto-generated method stub
		return (this.getName()).compareTo(o.getName());
	}

	@Override
	public int compare(Resource o1, Resource o2) {
		// TODO Auto-generated method stub
		return (o1.getName()).compareTo(o2.getName());
	}
		
	// Get Methods
	public String getName () {
		return name;
	}
	
	// Put Methods
	private void setName (String iName) {
		name = iName;
	}
}
