package items;

public class BaseResource {
	private int weight;
	
	private boolean flammible;
	
	// Constructors
	public BaseResource (int iWeight) {
		makeFlammible();
		weight = iWeight;
	}
	
	// Get methods
	public boolean isFlammible () {
		return flammible;
	}
	
	// Set Methods
	public void makeFlammible (boolean b) {
		flammible = b;
	}
	public void makeFlammible () {
		flammible = true;
	}
	
}
