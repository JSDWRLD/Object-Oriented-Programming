
import java.text.NumberFormat;

/**
 * Two-day package which extends the Package class.
 * It calculates the cost of shipping including an additional flat fee for two-day shipping.
 */
public class TwoDayPackage extends Package {
   
   /** The additional flat fee for two-day shipping. */
   private double flatFee = 3.50;
   
   /**
    * Constructs a TwoDayPackage object with specified attributes 
    * while using attributes from Package super class.
    *
    * @param flatFee           the flat fee for two-day shipping
    */
   TwoDayPackage(String name, String address, String city, String state, String ZIP, 
   double weight_in_ounces, double cost_per_ounce, double flatFee) {
      super(name, address, city, state, ZIP, weight_in_ounces, cost_per_ounce);
      this.flatFee = flatFee;
   }
   
   /**
    * Calculates the total cost of shipping including the flat fee for two-day shipping.
    * 
    * @return the total cost of shipping
    */
   public double calculateCost(){
      return super.calculateCost() + flatFee;
   }
   
   /**
    * Gets the flat fee for two-day shipping.
    * 
    * @return the flat fee for two-day shipping
    */
   public double getFlatFee(){
      return flatFee;
   }
   
   /**
    * Sets the flat fee for two-day shipping.
    * 
    * @param flatFee the new flat fee for two-day shipping
    */
   public void setFlatFee(double flatFee){
      this.flatFee = flatFee;
   }
   
   /**
    * Generates a string representation of the TwoDayPackage object.
    * 
    * @return a string representation of the object
    */
   public String toString(){
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      
      return "\nName: " + getName() + " Address: " + getAddress() + " City: " + getCity() + " State: " + getState() + " ZIP: " + getZIP() + "\nWeight (oz): " + getWeight_in_ounces() + " Cost of Shipping per ounce: " + getCost_per_ounce() + "\nTotal Basic Shipping cost " + currency.format(super.calculateCost()) + "\nAdd Flat Two Day Fee: " + flatFee + "\nTotal TwoDay Shipping Fee cost " + currency.format(calculateCost());      
   }
}