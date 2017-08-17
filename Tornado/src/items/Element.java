package items;

public class Element implements java.io.Serializable {
	private static final long serialVersionUID = -1430964563703832789L;
	
	private int atomicNumber;
	private ElementCategory category;
	private int elecronegativity;
	private int density;
	private int meltingPoint;
	private int boilingPoint;


	// Constructors
	public Element (int id,
					ElementCategory cat,
					int en,
					int dsty,
					int mp,
					int bp
					) {
		atomicNumber = id;
		category = cat;
		elecronegativity = en;
		density = dsty;
		meltingPoint = mp;
		boilingPoint = bp;
	}
	
	// Get Methods
	public int id () {
		return atomicNumber;
	}
	
	// Set Methods

}
