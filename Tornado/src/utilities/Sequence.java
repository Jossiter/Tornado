package utilities;

public class Sequence {
	private int number = 0;
	
	// Get methods
	public int get () {
		return number;
	}
	public int getNext () {
		return ++number;
	}
	
	// Set methods
	public void clear () {
		number = 0;
	}
	public void set (int value) {
		number = value;
	}

}
