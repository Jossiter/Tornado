package FactoryDemo;

public class ResourceFactory {

	   //use getShape method to get object of type shape 
	   public Resource getShape(String resourceType) {
	      if(resourceType == null){
	         return null;
	      }		
	      if(resourceType.equalsIgnoreCase("INGREDIENT")) {
	         return new Ingredient("A");
	      }
	         
	      return null;
	   }

}
