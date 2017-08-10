package map;

public class Coordinate implements java.io.Serializable {
	private static final long serialVersionUID = -7465039269371946862L;
	protected long x = 0;
	protected long y = 0;
	protected long h = 0;
	
	// constructors
	public Coordinate () {
		this.set(0, 0, 0);
	}
	public Coordinate (long ix, long iy, long ih) {
		this.set(ix, iy, ih);
	}
	public Coordinate (long ix, long iy) {
		this.set(ix, iy, 0);
	}
	public Coordinate (Coordinate iCo) {
		this.set(iCo);
	}
	
	// set methods
	public void set (long ix, long iy, long ih) {
		this.x = ix;
		this.y = iy;
		this.h = ih;
	}
	public void set (Coordinate iCo) {
		this.x = iCo.x;
		this.y = iCo.y;
		this.h = iCo.h;
	}

}

