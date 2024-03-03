

import java.text.NumberFormat;


/**
 * Regular package
 */
public class Package {
   
   // Attributes
   private String name;
   private String address;
   private String city;
   private String state;
   private String ZIP;
   private double weight_in_ounces;
   private double cost_per_ounce;
   
   
  /**
   * Constructs a new Package object with the specified information
   *
   * @param name              the recipient's name
   * @param address           the recipient's address
   * @param city              the recipient's city
   * @param state             the recipient's state
   * @param ZIP               the recipient's ZIP code
   * @param weight_in_ounces  the weight of the package in ounces
   * @param cost_per_ounce    the cost of shipping per ounce
   */
   Package(String name, String address, String city, String state, String ZIP, 
   double weight_in_ounces, double cost_per_ounce) {
      this.name = name;
      this.address = address;
      this.city = city;
      this.state = state;
      this.ZIP = ZIP;
      this.weight_in_ounces = weight_in_ounces;
      this.cost_per_ounce = cost_per_ounce;
   }
   
   /**
	 * Multiplies the weight times the cost per ounce
	 *
	 * @return a double, which is the total cost of the item
	 */
   public double calculateCost(){
      return weight_in_ounces * cost_per_ounce;
   }
   
  /**
   * Generates a string representation of the Package object.
   *
   * @return a string representation of the object
   */
   public String toString(){
      // Create a number formatter for currency
      NumberFormat currency = NumberFormat.getCurrencyInstance();
        
      return "\nName: " + name + " Address: " + address + " City: " + city + " State: " + state + " ZIP: " + "\nWeight (oz): " + weight_in_ounces + " Cost of Shipping per ounce: " + cost_per_ounce + "\nTotal Basic Shipping cost " + currency.format(calculateCost());
   
   }
   
   // Getters
   
   /**
    * Retrieves the recipient's name.
    *
    * @return the recipient's name
    */
   public String getName(){
      return name;
   }
   
    /**
    * Retrieves the recipient's address.
    *
    * @return the recipient's address
    */
   public String getAddress(){
      return address;
   }
   
   /**
    * Retrieves the recipient's city.
    *
    * @return the recipient's city
    */
   public String getCity(){
      return city;
   }
   
    /**
    * Retrieves the recipient's state.
    *
    * @return the recipient's state
    */
   public String getState(){
      return state;
   }
   
   /**
    * Retrieves the recipient's ZIP code.
    *
    * @return the recipient's ZIP code
    */
   public String getZIP(){
      return ZIP;
   }
   
    /**
    * Retrieves the weight of the package in ounces.
    *
    * @return the weight of the package in ounces
    */
   public double getWeight_in_ounces(){
      return weight_in_ounces;
   }
   
   /**
    * Retrieves the cost of shipping per ounce.
    *
    * @return the cost of shipping per ounce
    */
   public double getCost_per_ounce(){
      return cost_per_ounce;
   }
   
   
   // Setters
   
   /**
    * Sets the recipient's name.
    *
    * @param name the recipient's name
    */
   public void setName(String name){
      this.name = name;
   }
   
   /**
    * Sets the recipient's address.
    *
    * @param address the recipient's address
    */
   public void setAddress(String address){
      this.address = address;
   }
   
   /**
    * Sets the recipient's city.
    *
    * @param city the recipient's city
    */   
   public void setCity(String city){
      this.city = city;
   }
   
   /**
    * Sets the recipient's state.
    *
    * @param state the recipient's state
    */   
   public void setState(String state){
      this.state = state;
   }
   
   /**
    * Sets the recipient's ZIP code.
    *
    * @param ZIP the recipient's ZIP code
    */
   public void setZIP(String ZIP){
      this.ZIP = ZIP;
   }
   
    /**
    * Sets the weight of the package in ounces.
    *
    * @param weight_in_ounces the weight of the package in ounces
    */
   public void setWeight_in_ounces(double weight_in_ounces){
      this.weight_in_ounces = weight_in_ounces;
   }
   
   /**
    * Sets the cost of shipping per ounce.
    *
    * @param cost_per_ounce the cost of shipping per ounce
    */
   public void setCost_per_ounce(double cost_per_ounce){
      this.cost_per_ounce = cost_per_ounce;
   }
   
   
}