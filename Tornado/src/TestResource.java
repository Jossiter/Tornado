import cookbook.Resource;

public class TestResource {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    String ResourceTestName = "Water";
		String ResourceTestPrint = ResourceTestName;
		
		System.out.println("** RESOURCE TESTS **");
		
		Resource water = new Resource(ResourceTestName);
		Resource amber = new Resource("Amber");
		Resource water2 = new Resource(ResourceTestName);
		
		// Check name
		System.out.print("#TEST 001# ");
		if (water.getName() == ResourceTestName) {
			System.out.println("Name Test Passed : " + water.getName());
		} else {
			System.out.println("@FAILED");
		}
		
		// Check print
		System.out.print("#TEST 002# ");
		if (water.print() == ResourceTestPrint) {
			System.out.println("Print Test Passed : " + water.print());
		} else {
			System.out.println("@FAILED");
		}
		
		// CompareTo greater than
		System.out.print("#TEST 003# ");
		if (water.compareTo(amber) > 0) {
			System.out.println("Water > Amber CompareTo Test Passed");
		} else {
			System.out.println("@FAILED");
		}

		// CompareTo equal
		System.out.print("#TEST 004# ");
		if (water.compareTo(water2) == 0) {
			System.out.println("Water = Water2 CompareTo Test Passed");
		} else {
			System.out.println("@FAILED");
		}
		
		// Compare
		System.out.print("#TEST 005# ");
		if (water.compare(amber, water2) < 0) {
			System.out.println("Water: Amber < Water2 Comparison Test Passed");
		} else {
			System.out.println("@FAILED");
		}
}

}
