package track;

public class BlockExit {
	Block[] block;
	static int maxExits = 3;
	
	// Constructors
	public BlockExit() {
		block = new Block[maxExits];
		clearExits();
	}
	public BlockExit(Block mainExit) {
		block = new Block[maxExits];
		clearExits();
		setMainExit(mainExit);
	}
	public BlockExit(Block mainExit, Block branchExit) {
		block = new Block[maxExits];
		clearExits();
		setMainExit(mainExit);
		setBranchExit(branchExit);
	}	
	public BlockExit(Block mainExit, Block branchExit, Block branchAlt) {
		block = new Block[maxExits];
		clearExits();
		setMainExit(mainExit);
		setBranchExit(branchExit);
		setBranchAlt(branchAlt);
	}
	// Get Methods
	
	// Set Methods
	public void clearExits () {
		for (int i = 0; i < maxExits; i++) {
			block[i] = null;
		}		
	}
	public void setMainExit (Block exit) {
		block[0] = exit;
	}
	public void setBranchExit (Block exit) {
		block[1] = exit;
	}
	public void setBranchAlt (Block exit) {
		block[2] = exit;
	}
}
