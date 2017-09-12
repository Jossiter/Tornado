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
	@Override
	public int compareTo(Resource o) {
		// TODO Auto-generated method stub
		return (this.print()).compareTo(o.print());
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
