package cookbook;

import java.util.TreeSet;

public class ResourceFactory {
	int resourceIdentifier = 0;
	private TreeSet<String> uniqueResources = null;
	
	// Constructors
	public ResourceFactory () {
		clearResources();
		clearResourceIndex();
	}
	   
	public Resource getResource (String resourceName) {
		Resource retResource = null;
		
		if(testResource(resourceName)) {
			retResource = new Resource (++resourceIdentifier, resourceName);
		}
		
		return retResource;
	}      
	
	public Resource getResource (String resourceName, Type resourceType) {
		Resource retResource = null;
		
		if(testResource(resourceName)) {
			retResource = new Resource (++resourceIdentifier, resourceName, resourceType);
		}
		
		return retResource;
	} 	
	
	// Set Methods
	private void clearResources () {
		resourceIdentifier = 0;
	}
	private void clearResourceIndex() {
		uniqueResources = new TreeSet<String>();
	}
	private boolean testResource(String resourceName) {
		boolean ret = true;
		
		if(resourceName == null){
			ret = false;
		} else if (! uniqueResources.add(resourceName)) {
			ret = false;		
		}
		
		return ret;
	}
}
