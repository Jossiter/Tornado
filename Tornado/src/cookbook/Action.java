package cookbook;

public class Action {

	private String name = null;
	
	// Constructors
	public Action (String iName) {
		setName(iName);
	}
		
	// Get Methods
	public String getName () {
		return name;
	}
	
	// Put Methods
	private void setName (String iName) {
		name = new String(iName.toString());
	}
}
