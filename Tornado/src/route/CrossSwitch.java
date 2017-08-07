package track;

public class CrossSwitch extends Switch {
	protected Block upBranch;

	// Constructors
	public CrossSwitch() {
		clearUpBranch();
	}

	// Get Methods
	public BlockExit nextBlock (Block previousBlock) {
		Block exit1, exit2;
		
		if (previousBlock == upMain) {
			exit1 = downMain;
			exit2 = downBranch;
			} 
		else if (previousBlock == downMain) {
			exit1 = upMain;
			exit2 = upBranch;
			} 
		else if (previousBlock == upBranch) {
			exit1 = downMain;
			exit2 = downBranch;
			} 
		else if (previousBlock == downBranch) {
			exit1 = upMain;
			exit2 = upBranch;
			}
		else {
			exit1 = null;
			exit2 = null;
			}

		return new BlockExit(exit1, exit2);
	}
	
	// Set Methods
	public void clearUpBranch () {
		upBranch = null;
	}	
	public void setUpBranch (Block iBlock) {
		upBranch = iBlock;
	}
}

