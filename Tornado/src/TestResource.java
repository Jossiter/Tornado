import cookbook.Resource;
import cookbook.ResourceFactory;

public class TestResource {


	public static void main(String[] args) {
		ResourceFactory resourceFactory = new ResourceFactory();
		
	    String ResourceTestName = "Water";
		String ResourceTestPrint = ResourceTestName;
		String ResourceTestPrintID = "[2] " + ResourceTestPrint;
		
		System.out.println("** RESOURCE TESTS **");
		
		Resource amber = resourceFactory.getResource("Amber");
		Resource water = resourceFactory.getResource(ResourceTestName);
		
		// Check name
		System.out.print("#TEST 010# ");
		if (water.getName() == ResourceTestName) {
			System.out.println("Name Test Passed : " + water.getName());
		} else {
			System.out.println("@FAILED");
		}
		
		// Check print
		System.out.print("#TEST 020# ");
		if (water.print() == ResourceTestPrint) {
			System.out.println("Print Test Passed : " + water.print());
		} else {
			System.out.println("@FAILED");
		}
		
		// CompareTo greater than
		System.out.print("#TEST 030# ");
		if (water.compareTo(amber) > 0) {
			System.out.println("Water > Amber CompareTo Test Passed");
		} else {
			System.out.println("@FAILED");
		}

		// CompareTo equal
		System.out.print("#TEST 040# ");
		if (water.compareTo(water) == 0) {
			System.out.println("Water == Water CompareTo Test Passed");
		} else {
			System.out.println("@FAILED");
		}

		// Can't create duplicate
		System.out.print("#TEST 050# ");
		if (resourceFactory.getResource(ResourceTestName.toUpperCase()) == null) {
			System.out.println("Can't create WATER: Test Passed");
		} else {
			System.out.println("@FAILED");
		}
		
		// Compare
		System.out.print("#TEST 060# ");
		if (water.compare(amber, water) < 0) {
			System.out.println("Water: Amber < Water Comparison Test Passed");
		} else {
			System.out.println("@FAILED");
		}
		
		// Check ID print
		System.out.print("#TEST 070# ");
		if (water.printID().compareTo(ResourceTestPrintID) == 0) {
			System.out.println("Print ID Test Passed : " + water.printID());
		} else {
			System.out.println("@FAILED : '" + water.printID() + "' / '" + ResourceTestPrintID + "'");
		}
		
		
}

}
