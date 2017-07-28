package utilities;

import java.util.Random;

public class Randnum {
	private Random rand;

	// Constructors 
	public Randnum () {
		this.rand = new Random(System.currentTimeMillis());
	}
	
	public Randnum (long seed) {
		setSeed(seed);
	}
	
	
	// Get Methods
	public int getNextD6() {		
		int  n = this.rand.nextInt(6) + 1;
		//6 is the maximum and the 1 is our minimum 
		
		return n;
	}
	
	
	// Set Methods
	public void setSeed(long seed) {
		this.rand = new Random(seed);
	}

}
