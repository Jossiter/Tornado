package cookbook;

import java.util.Comparator;

public class Resource implements Comparator<Resource>, Comparable<Resource> {
	private String name = null;
	private int id = 0;
	private Type type = Type.BASE;
	
	// Constructors
	public Resource (String iName) {
		setName(iName);
	}
	public Resource (int iD, String iName) {
		setName(iName);
		setID(iD);
	}
	public Resource (int iD, String iName, Type iType) {
		setName(iName);
		setID(iD);
		setType(iType);
	}
	protected Resource (Resource orig) {
		setName(orig.name);
		setID(orig.id);
		setType(orig.type);
	}
	
	// Comparators
	@Override
	public int compareTo(Resource o) {
		// TODO Auto-generated method stub
		if (o == null) {
			return 1;
		}

		return (this.print().toLowerCase()).compareTo(o.print().toLowerCase());
	}

	@Override
	public int compare(Resource o1, Resource o2) {
		// TODO Auto-generated method stub
		if (o1 == null || o2 == null) {
			return -1;
		}
		
		return (o1.print().toLowerCase()).compareTo(o2.print().toLowerCase());
	}
		
	// Get Methods
	public String getName () {
		return name;
	}
	
	// Put Methods
	private void setName (String iName) {
		name = iName;
	}
	private void setID (int iD) {
		id = iD;
	}
	private void setType (Type iType) {
		type = iType;
	}
	
	// Output methods
	public String print () {
		return getName();
	}
	public String printID () {
		return "[" + id + "] " + getName();
	}
}
