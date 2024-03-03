

import java.text.NumberFormat;


/**
 * Overnight package which extends the Package class.
 * This calculates the cost of shipping including an additional overnight fee per ounce.
 */
public class OvernightPackage extends Package {
   
  /** The additional fee per ounce for overnight shipping. */
   private double overnightFee = 0.45;
   
  /**
   * Constructs an OvernightPackage object with specified attributes and
   * while using attributes from Package super class.
   *
   * @param flatFee           the flat fee for shipping
   */
   OvernightPackage(String name, String address, String city, String state, String ZIP, 
   double weight_in_ounces, double cost_per_ounce, double flatFee) {
      super(name, address, city, state, ZIP, weight_in_ounces, cost_per_ounce);
      this.overnightFee = overnightFee;
   }
   
  /**
   * Calculates the total cost of shipping including the overnight fee.
   * 
   * @return the total cost of shipping
   */
   public double calculateCost(){
      return super.calculateCost() + (getWeight_in_ounces() * overnightFee);
   }
   
  /**
   * Gets the overnight fee per ounce.
   * 
   * @return the overnight fee per ounce
   */
   public double getOvernightFee(){
      return overnightFee;
   }
   
  /**
   * Sets the overnight fee per ounce.
   * 
   * @param overnightFee the new overnight fee per ounce
   */
   public void setOvernightFee(double overnightFee){
      this.overnightFee = overnightFee;
   }
   
  /**
   * Generates a string representation of the OvernightPackage object.
   * 
   * @return a string representation of the object
   */
   public String toString() {
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      
      return "\nName: " + getName() + " Address: " + getAddress() + " City: " + getCity() + " State: " + getState() + " ZIP: " + getZIP() + "\nWeight (oz): " + getWeight_in_ounces() + " Cost of Shipping per ounce: " + getCost_per_ounce() + "\nTotal Basic Shipping cost " + currency.format(super.calculateCost()) + "\nAdd Overnight Fee per oz: " +  overnightFee + "\nTotal Overnight Shipping Fee cost " + currency.format(calculateCost());
   }
}