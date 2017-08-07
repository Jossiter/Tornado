package map;

import utilities.Direction;
import static map.Constants.*;

public class Box {
	Hex hex;
	Coordinate coord;

	// Constructors 
	public Box (int ix, int iy) {
		hex = null;
		setXY (ix, iy);
	}
	
	// Get Methods
	public Coordinate getCoord () {
		return coord;
	}
	public Coordinate getCoord (Direction iDirection) {
		Coordinate c = new Coordinate(coord);
		
		if (c.x < 1 || c.y < 1 || c.x > MAXX - 2 || c.y > MAXY - 2) {
			c.x = -1;
			c.y = -1;
		}
		
		if (iDirection == Direction.WEST || iDirection == Direction.NW || iDirection == Direction.SW) {
			c.x--;			
		}
		if (iDirection == Direction.EAST || iDirection == Direction.NE || iDirection == Direction.SE) {
			c.x++;			
		}		
		if (iDirection == Direction.SOUTH || iDirection == Direction.SE || iDirection == Direction.SW) {
			c.y--;			
		}
		if (iDirection == Direction.NORTH || iDirection == Direction.NE || iDirection == Direction.NW) {
			c.y++;			
		}
		
		if (c.x < 1 || c.y < 1 || c.x > MAXX - 2 || c.y > MAXY - 2) {
			c.x = 0;
			c.y = 0;
		}
		
		return c;
	}
	
	// Set Methods
	private void setXY (int ix, int iy) {
		coord = new Coordinate(ix, iy);
	}
	
	// Print Methods
	public String textGrid () {
		return "[" + String.format("%03d",coord.x) + "," + String.format("%03d",coord.y) + "]";
	}
}
