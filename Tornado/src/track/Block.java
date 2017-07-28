package track;

public class Block {
	private signal.Semaphore occupied;
	// private map.Coordinate mainUp;
	// private map.Coordinate mainDown;

	// Constructors
	public Block () {
		occupied = new signal.Semaphore();
		setClear();
	}
	
	// Get methods
	public boolean state () {
		return occupied.state();
	}
	public boolean isClear(){
		return occupied.isClear();
	}
	public boolean isOccupied () {
		return occupied.isOccupied();
	}
	
	// Set methods
	public void setOccupied () {
		this.occupied.setOccupied();
	}
	public void setClear () {
		this.occupied.setClear();
	}
}

