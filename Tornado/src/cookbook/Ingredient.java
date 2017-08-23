package cookbook;

import java.util.Comparator;

public class Ingredient implements Comparator<Ingredient>, Comparable<Ingredient> {
	private Resource resource;
	private int quantity;
	
	// Constructors 
	public Ingredient(Resource iResource) {
		resource = iResource;
		setQty(1);
	}	
	public Ingredient(Resource iResource, int iQuantity) {
		resource = iResource;
		this.setQty(iQuantity);
		
	}	public Ingredient(String iName) {
		resource = new Resource(iName);
		setQty(1);
	}	
	public Ingredient(String iName, int iQuantity) {
		resource = new Resource(iName);
		this.setQty(iQuantity);
	}
	
	// Comparators 
	@Override
	public int compareTo(Ingredient o) {
		// TODO Auto-generated method stub
		return (this.print()).compareTo(o.print());
	}
	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		// TODO Auto-generated method stub
		return (o1.print()).compareTo(o2.print());
	}
	
	// get methods
	public int getQty () {
		return quantity;
	}
	public String getName () {
		return resource.getName();
	}
	
	// set methods
	private void setQty (int q) {
		quantity = q;
	}
	
	// print methods
	public String print() {
		return getName() + " x" + getQty();
	}
}
