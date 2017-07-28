package signal;

public class Semaphore {
	private boolean state;

	// constructors
	public Semaphore () {
		setClear(); 
	}
	public Semaphore (boolean iState) {
		setState(iState);
	}
	
	// get methods
	public boolean state () {
		return this.state;
	}
	public boolean isClear () {
		return this.state;
	}
	public boolean isOccupied () {
		return !this.state;
	}
	
	
	// set methods
	public void setClear () {
		this.state = true;
	}
	
	public void setOccupied () {
		this.state = false;
	}
	
	void setState (boolean iState) {
		this.state = iState;
	}
}