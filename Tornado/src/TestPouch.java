import cookbook.Ingredient;
import cookbook.Pouch;
import cookbook.Resource;

public class TestPouch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pouch i = new Pouch();
		printBag(i);
		
		System.out.println("");
		System.out.print("Adding water : ");
		System.out.println(i.add(new Resource ("Water")));
		printBag(i);
		
		System.out.println("");
		System.out.print("Adding 2 Rice : ");
		Resource r = new Resource("Rice");
		Ingredient g =  new Ingredient (r, 2);
		System.out.println(i.add(g));
		printBag(i);
		
		System.out.println("");
		System.out.print("Adding 3 more water : ");
		System.out.println(i.add(new Resource ("Water"), 3));
		printBag(i);
		
		System.out.println("");
		System.out.print("Removing 2 more water : ");
		System.out.println(i.remove(new Resource ("Water"), 2));
		printBag(i);
		
		System.out.println("");
		System.out.print("Removing all water : ");
		System.out.println(i.remove(new Resource ("Water")));
		printBag(i);
		
		System.out.println("");
		System.out.print("Clear the bag : ");
		i.clear();
		printBag(i);
	}
	
	private static void printBag(Pouch bag) {
		System.out.print("Bag contents (" + bag.qty() + "): ");
		System.out.println(bag.print());
		System.out.println("End of bag");		
	}

}
