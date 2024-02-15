/**
@date 2-11-2024
@description Assignment 1: This program works like a shopping cart you can add items or remove them from array.
*/

// Importing number formatter for toString method
import java.text.*;

class Item {
   
   // Private attributes
   private String item;
   private double price;
   private int bulkQuantity;
   private double bulkPrice;
   
   /** 
   Class constructor:  There are two class constructors, one for standard items and one for items with bulk pricing.

   */
   // Constructor with only name and price
   public Item(String item, double price){
      this.item = item;
      this.price = price;
   }
   
   // Constructor for bulk items
   public Item(String item, double price, int bulkQuantity, double bulkPrice){
      this.item = item;
      this.price = price;
      this.bulkQuantity = bulkQuantity;
      this.bulkPrice = bulkPrice;
   }
   
  
   /** 
   @param  quantity - quantity of item in question being returned
   @return item returns the item's name
   @throws IllegalArgumentException if user input is a negative quantity,
   
   */
   
   // if quantity < bulk quantity && > 0 then etc
   public double priceFor(int quantity){
      if (quantity < bulkQuantity && quantity > 0){
         return quantity*price;
      } else if(quantity >= bulkQuantity){
         return bulkPrice*quantity;
      } else {
         throw new IllegalArgumentException("negative quantity");
      }
   }
   
   // This method returns a string version of the current item depending on whether or not there is bulk.
   public String toString(){
      NumberFormat nf = NumberFormat.getCurrencyInstance();
      String text = nf.format(price);
      String bulkText = nf.format(bulkPrice);
      if ( bulkQuantity > 0 ) {
         return item + ", " + text + " (" + bulkQuantity + " for " + bulkText + ")";
      } else {
         return item + ", " + text;
      }
   }
   
   // This method simply returns the name of the item.
   public String getName(){
      return item;
   }
   
   // This method returns a boolean value depending on if the item is empty or not.
   public boolean isEmpty(){
      return item == null && price == 0 && bulkQuantity == 0 && bulkPrice == 0;
   }
}