import java.util.HashSet;
import java.util.Iterator;

import map.Grid;
import map.Hex;
import utilities.Direction;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hex x1 = new Hex("X1");
		x1.print();
		System.out.println( );		
		
		Hex x2 = new Hex("X2");
		x2.print();
		System.out.println( );	
		
		x1.setDirection(Direction.NE, x2);
		
		x1.print();
		System.out.println( );		
		x2.print();
		System.out.println( );	
		
		x1.clearDirection(Direction.NE);
		
		x1.print();
		System.out.println( );		
		x2.print();
		System.out.println( );	
		
		Grid g = new Grid();
		g.print();

	      System.out.println( "Collection Test" );
	      // Create a collection
	      HashSet collection = new HashSet();
	      // Adding
	      String dog1 = "Max", dog2 = "Bailey", dog3 = "Harriet";
	      collection.add( dog1 );
	      collection.add( dog2 );
	      collection.add( dog3 );
	      // Sizing
	      System.out.println( "Collection created" + 
	        ", size=" + collection.size() + 
	        ", isEmpty=" + collection.isEmpty() );
	      // Containment
	      System.out.println( "Collection contains " + dog3 + 
	         ": " + collection.contains( dog3 ) );
	      // Iteration. Iterator supports hasNext, next, remove
	      System.out.println( "Collection iteration (unsorted):" );
	      Iterator iterator = collection.iterator();
	      while ( iterator.hasNext() ) 
	         System.out.println( "   " + iterator.next() );
	      // Removing
	      collection.remove( dog1 );
	      collection.clear();
	}

}
