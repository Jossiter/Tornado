import map.Grid;
import map.Hex;
import utilities.Direction;

public class TestMap {


	public static void main(String[] args) {

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
	}
}

