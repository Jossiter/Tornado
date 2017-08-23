package FactoryDemo;

public class Ingredient extends Resource {
	private int quantity;
	
	// Constructors 
	public Ingredient(String iName) {
		super(iName);
		setQty(1);
	}	
	public Ingredient(String iName, int iQuantity) {
		super(iName);
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
	public String print () {
		return super.print() + " x" + getQty();
	}
}
