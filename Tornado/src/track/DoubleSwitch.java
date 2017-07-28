package track;

public class DoubleSwitch extends Switch {
	protected Block downAlt;
	
	
	// Constructors
	public DoubleSwitch() {
		clearDownAlt();
	}

	// Get Methods
	public BlockExit nextBlock (Block previousBlock) {
		Block exit1, exit2, exit3;
		
		if (previousBlock == upMain) {
			exit1 = downMain;
			exit2 = downBranch;
			exit3 = downAlt;
			} 
		else if (previousBlock == downMain) {
			exit1 = upMain;
			exit2 = null;
			exit3 = null;
			} 
		else if (previousBlock == downBranch) {
			exit1 = upMain;
			exit2 = null;
			exit3 = null;
			} 
		else if (previousBlock == downAlt) {
			exit1 = upMain;
			exit2 = null;
			exit3 = null;
			}
		else {
			exit1 = null;
			exit2 = null;
			exit3 = null;
			}

		return new BlockExit(exit1, exit2, exit3);
	}

	// Set Methods
	public void clearDownAlt () {
		downAlt = null;
	}	
	public void setDownAlt (Block iBlock) {
		downAlt = iBlock;
	}
}

