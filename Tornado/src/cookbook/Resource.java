package cookbook;

import java.util.Comparator;

public class Resource implements Comparator<Resource>, Comparable<Resource> {
	private String name = null;
	
	// Constructors
	public Resource (String iName) {
		setName(iName);
	}
	protected Resource (Resource orig) {
		name = orig.name;
	}
	
	// Comparators
	@Override
	public int compareTo(Resource o) {
		// TODO Auto-generated method stub
		return (this.print()).compareTo(o.print());
	}

	@Override
	public int compare(Resource o1, Resource o2) {
		// TODO Auto-generated method stub
		return (o1.print()).compareTo(o2.print());
	}
		
	// Get Methods
	public String getName () {
		return name;
	}
	
	// Put Methods
	private void setName (String iName) {
		name = iName;
	}
	
	// Output methods
	public String print () {
		return getName();
	}
}
