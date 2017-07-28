package map;

public class Coordinate {
	protected long x = 0;
	protected long y = 0;
	protected long h = 0;
	
	// constructors
	public Coordinate (long ix, long iy, long ih) {
		this.set(ix, iy, ih);
	}
	public Coordinate (Coordinate iCo) {
		this.set(iCo);
	}
	
	// get methods
	public long X () {
		return this.x;
	}
	public long Y () {
		return this.y;
	}
	public long H () {
		return this.h;
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

