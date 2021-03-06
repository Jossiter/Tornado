package Xactions;

public class Spin {
	protected Rating rate = new Rating();
	protected int forward;
	private static final int DEFAULT_RATE = 1, 
							 DEFAULT_FORWARD = 1;
	
	
	// Constructors
	public Spin (int iMin, int iMax) {
		rate.set(iMin, iMax, DEFAULT_RATE);
		this.setForward(DEFAULT_FORWARD);
	}
	public Spin (int iMin, int iMax, int iRate) {
		rate.set(iMin, iMax, iRate);
		this.setForward(DEFAULT_FORWARD);
	}
	public Spin (int iMin, int iMax, int iForward, int iRate) {
		rate.set(iMin, iMax, iRate);
		this.setForward(iForward);
	}
	
	
	// Get Methods
	public Rating getRate () {
		return rate;
	}
	
	
	// Set Methods
	private void setForward (int f) {
		forward = f;
	}	
}
