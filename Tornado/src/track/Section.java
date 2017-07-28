package track;

import utilities.Direction;
import utilities.Priority;
import static utilities.Direction.*;
import static utilities.Priority.*;

public class Section extends Block {
	protected Block upMain;
	protected Block downMain;
	
	protected Priority priority;
	protected Direction direction;

	
	// Constructors
	public Section() {
		// TODO Auto-generated constructor stub
		clearUp();
		clearDown();
		clearPriority();
		clearDirection();
	}
	
	// Get Methods
	/*
	public Block getUp () {
		return upBlock;
	}
	public Block getDown () {
		return downBlock;
	}
	*/
	public Priority getPriority () {
		return priority;
	}
	public Direction getDirection () {
		return direction;
	}		
	public BlockExit nextBlock (Block previousBlock) {
		Block exit;
		
		if (previousBlock == upMain) {
			exit = downMain;
			} 
		else if (previousBlock == downMain) {
			exit = upMain;
			} 
		else {
			exit = null;
			}

		return new BlockExit(exit);
	}
	
	// Set Methods
	public void clearUp () {
		upMain = null;
	}
	public void clearDown () {
		downMain = null;
	}
	public void clearPriority () {
		priority = ALL;
	}
	public void clearDirection () {
		direction = OPEN;
	}
	public void setUp (Block iBlock) {
		upMain = iBlock;
	}
	public void setDown (Block iBlock) {
		downMain = iBlock;
	}
	public void setPriority (Priority iPriority) {
		priority = iPriority;
	}
	public void setDirection (Direction iDirection) {
		direction = iDirection;
	}
}

