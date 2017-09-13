package cookbook;

public class Ingredient extends Resource {
	private int quantity;
	
	// Constructors 
	public Ingredient(Resource resource) {
		super(resource);
		setQty(1);
	}	
	public Ingredient(Resource resource, int qty) {
		super(resource);
		this.setQty(qty);
		
	}
	
	// Comparators
	public int equals (Ingredient i) {
		// TODO Auto-generated method stub
		return (this.printQuantity().toLowerCase()).compareTo(i.printQuantity().toLowerCase());
	}
	
	// get methods
	public int getQty () {
		return quantity;
	}
	
	// set methods
	protected void setQty (int q) {
		quantity = q;
	}
	
	// print methods
	public String printQuantity() {
		return getName() + " x" + getQty();
	}
}
