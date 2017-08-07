package track;

public class Switch extends Section {
	protected Block downBranch;
	
	
	// Constructors

	public Switch() {
		clearDownBranch();
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
			exit2 = null;
			} 
		else if (previousBlock == downBranch) {
			exit1 = upMain;
			exit2 = null;
			} 
		else {
			exit1 = null;
			exit2 = null;
			}

		return new BlockExit(exit1, exit2);
	}	
	
	// Set Methods
	public void clearDownBranch () {
		downBranch = null;
	}	
	public void setDownBranch (Block iBlock) {
		downBranch = iBlock;
	}
}

