package map;

import static map.Constants.*;

public class Grid implements java.io.Serializable {
	private static final long serialVersionUID = 818574520401754708L;

	private Box gridbox[][] = new Box[MAXX + 2][MAXY + 2];
	
	//constructors
	public Grid () {
		clear();
	}
	
	// Get Methods
	
	// Set Methods
	private void clear () {
		for (int x = 0; x < MAXX + 2; x++) {
			for (int y = 0; y < MAXY + 2; y++) {
				if (x == 0 || y == 0  || x == MAXX+1 || y == MAXY+1) {
					gridbox[x][y] = null;
				} else {
					gridbox[x][y] = new Box(x,y);
				}
			}
		}		
	}
	
	// Print
	public void print () {
		String mapline;
		
		for (int y = MAXY + 1; y >= 0; y--) {
			mapline = "";			
			for (int x = 0; x < MAXX + 2; x++) {
				if (gridbox[x][y] == null) {
					mapline = mapline + "[000,000]";
				} else {
					mapline = mapline + gridbox[x][y].textGrid();
				}
			}
			System.out.println(mapline);
		}			
	}
}
