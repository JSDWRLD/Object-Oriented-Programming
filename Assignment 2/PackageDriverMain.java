
import java.text.NumberFormat;

/**
 * This class uses Package, TwoDayPackage, and OvernightPackage classes.
 * It creates instances of these classes and calculates the total cost of shipping for the packages.
 */
public class PackageDriverMain {
   
   /**
    * The main method of the program.
    * 
    */
   public static void main(String[] args){
      
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      
      Package one = new Package("John Smith", "1020 Orange St", "Lakeland", "FL", "92317", 3.75, 0.67);
      Package two = new TwoDayPackage("Bob George", "121 Pine Rd", "Cambridge", "MA", "429024", 3.75, 0.67, 3.50);
      Package three = new OvernightPackage("Don Kelly", "9 Main St", "Denver", "CO", "66456", 3.75, 0.67, 0.45);
      
      System.out.println(one.toString());
      System.out.println(two.toString());
      System.out.println(three.toString());
      
      Package[] packageArray = {one, two, three};
      System.out.println(String.format("\nTotal cost of packages: %.3f", totalCostCalculator(packageArray)));
   
   }
   
    /**
    * Calculates the total cost of shipping for an array of packages.
    * 
    * @param packageArray the array of Package objects
    * @return the total cost of shipping for all packages
    */
   public static double totalCostCalculator(Package[] packageArray){
      double total = 0;
      for(Package current: packageArray){
         total += current.calculateCost();
      }
      
      return total;
   }






}