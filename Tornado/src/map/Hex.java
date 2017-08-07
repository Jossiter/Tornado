package map;

import route.Semaphore;
import utilities.Direction;

public class Hex {
	private static int maxExits = 6;
	
	private String name;
	private Hex[] exit = new Hex[maxExits];
	private route.Semaphore occupied = new route.Semaphore();	

	// Constructors
	public Hex () {
		clear();
		orphaned();
		setName("");
	}
	public Hex(String iName) {
		clear();
		orphaned();
		setName(iName);
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
	public String getName () {
		return name;
	}
	public Hex getHex (Direction iDirection) {
		Hex h = null;
		
		int i = resolveDirection(iDirection);
		if (i != -1) {
			h = exit[i];
		}
		
		return h;
	}


	
	// Set methods
	public void occupied () {
		this.occupied.setOccupied();
	}
	
	public void clear () {
		this.occupied.setClear();
	}
	
	public void orphaned () {
		for (int i = 0; i < maxExits; i++) {
			exit[i] = null;
		}				
	}
	
	public void setName (String iName) {
		name = iName;
	}
	
	public boolean setDirection (Direction toDirection, Hex toHex) {
		boolean b = false;
		
		if (this.mapDirection(toDirection, toHex)) {
			b = toHex.mapDirection(counterDirection(toDirection), this);
		}
		
		return b;
	}
	public boolean clearDirection (Direction toDirection) {
		boolean b = false;
		 
		Hex h = unmapDirection(toDirection);
		
		if (h != null) {
			h.unmapDirection(counterDirection(toDirection));
			b = true;
		}
		
		return b;
	}
	

	// Internal methods
	private boolean mapDirection (Direction toDirection, Hex toHex) {
		boolean b = true;
		
		int i = resolveDirection(toDirection);
		
		if (i == -1) {
			b = false;
		} else {
			exit[i] = toHex;
		}

		return b;
	}	
	private Hex unmapDirection (Direction toDirection) {
		Hex h = getHex (toDirection);
		
		if (h != null) {
			exit[resolveDirection(toDirection)] = null;
		}
		
		return h;
	}	
	
	private int resolveDirection (Direction iDirection) {
		int i;

		switch (iDirection) {
		case WEST:
			i = 0;
			break;
		case NW:
			i = 1;
			break;
		case NE:
			i = 2;
			break;
		case EAST:
			i = 3;
			break;
		case SE:
			i = 4;
			break;
		case SW:
			i = 5;
			break;
		default:
			i = -1;
			break;
		}
		
		return i;
	}	
	private Direction counterDirection (Direction iDirection) {
		Direction d;

		switch (iDirection) {
		case WEST:
			d = Direction.EAST;
			break;
		case NW:
			d = Direction.SE;
			break;
		case NE:
			d = Direction.SW;
			break;
		case EAST:
			d = Direction.WEST;
			break;
		case SE:
			d = Direction.NW;
			break;
		case SW:
			d = Direction.NE;
			break;
		default:
			d = Direction.NONE;
			break;
		}
		
		return d;		
	}
	private String nameBorder (Direction iDirection) {
		String xname;
		int i = resolveDirection(iDirection);
		
		if (i == -1) {
			xname = "-1";
		} else if (exit[i] == null) {
			xname = "0";
		} else {
			xname = exit[i].getName();
		}
		
		return xname;
	}
	
	// print
	public void print () {
		String topleftname = this.nameBorder(Direction.NW);
		String toprightname = this.nameBorder(Direction.NE);
		String middleleftname = this.nameBorder(Direction.WEST);
		String middlerightname = this.nameBorder(Direction.EAST); 
		String bottomleftname = this.nameBorder(Direction.SW);
		String bottomrightname = this.nameBorder(Direction.SE);
		
		int topleftsize = topleftname.length();
		int toprightsize = toprightname.length();
		int middleleftsize = middleleftname.length();
		int bottomrightsize = bottomrightname.length();
		int bottomleftsize = bottomleftname.length();
		
		String linetoprint = "";
		for (int i = middleleftsize + 1; i > 0; i--) {
			linetoprint = linetoprint + " ";			
		}
		for (int i = bottomleftsize - topleftsize; i >0 ; i--) {
			linetoprint = linetoprint + " ";
		}
		linetoprint = linetoprint + topleftname + " ";
		for (int i = name.length(); i > 0; i--) {
			linetoprint = linetoprint + " ";
		}
		linetoprint = linetoprint + " " + toprightname;		
		System.out.println(linetoprint);
		
		linetoprint = middleleftname + " ";
		int x = 1;
		if (topleftsize > bottomleftsize) {
			x = x + topleftsize;
		} else {
			x = x + bottomleftsize;
		}
		for (int i = x; i >0 ; i--) {
			linetoprint = linetoprint + " ";
		}	
		linetoprint = linetoprint + this.name + " ";
		x = 1;
		if (toprightsize > bottomrightsize) {
			x = x + toprightsize;
		} else {
			x = x + bottomrightsize;
		}
		for (int i = x; i >0 ; i--) {
			linetoprint = linetoprint + " ";
		}		
		System.out.println(linetoprint + middlerightname);
		
	    linetoprint = "";
		for (int i = middleleftsize + 1; i > 0; i--) {
			linetoprint = linetoprint + " ";			
		}
		for (int i =  topleftsize - bottomleftsize; i >0 ; i--) {
			linetoprint = linetoprint + " ";
		}
		linetoprint = linetoprint + bottomleftname + " ";
		for (int i = name.length(); i > 0; i--) {
			linetoprint = linetoprint + " ";
		}
		linetoprint = linetoprint + " " + bottomrightname;		
		System.out.println(linetoprint);		
		
			
	}
}

