package cookbook;

public class Ingredient extends Resource {
	private int quantity;
	
	// Constructors 
	public Ingredient(Resource iResource) {
		super(iResource);
		setQty(1);
	}	
	public Ingredient(Resource iResource, int iQuantity) {
		super(iResource);
		this.setQty(iQuantity);
		
	}
	
	// get methods
	public int getQty () {
		return quantity;
	}
	
	// set methods
	private void setQty (int q) {
		quantity = q;
	}
	
	// print methods
	public String printQuantity() {
		return getName() + " x" + getQty();
	}
}
