package actions;

public class Rating {
	protected int min, max, rate;
	protected final static int DEFAULT_VALUE = 1;
	
	// Constructor 
	public Rating () {
		setMin(DEFAULT_VALUE);
		setMax(DEFAULT_VALUE);
		setRate(DEFAULT_VALUE);
	}
	
	// get methods
	
	
	// set methods
	public void set (int n, int x, int r) {
		setMin(n);
		setMax(x);
		setRate(r);
	}	
	private void setMin (int n) {
		min = n;
	}
	private void setMax (int x) {
		min = x;
	}
	private void setRate (int r) {
		min = r;
	}
}
