package cookbook;

public class Ingredient extends Resource {
	private int quantity;
	
	// Constructors 
	public Ingredient(String iName, int iQuantity) {
		super(iName);
		this.setQty(iQuantity);
	}
	
	// get methods
	private int getQty () {
		return quantity;
	}
	
	// set methods
	private void setQty (int q) {
		quantity = q;
	}
}
