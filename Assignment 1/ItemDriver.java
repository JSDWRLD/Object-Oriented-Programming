/**

@date 2-11-2024
@description Assignment 1: This program works like a shopping cart you can add items or remove them from array.
*/


import java.io.*;
import java.util.*;


class ItemDriver {
     
     // Sets the intial size for the Array/Shopping Cart
     private static final int SIZE = 1;
    
     // TESTING AREA
     public static void main(String[] args) {
          Item[] itemList = new Item[SIZE];
          
          int numOfItems = 0;s
          // Filling the array with 4 items.
          numOfItems++;
          itemList = addItem(itemList, 1, "Shampoo", 4.99);
          numOfItems++;
          itemList = addItem(itemList, 2, "Toothpaste", 2.25);
          numOfItems++;
          itemList = addItem(itemList, numOfItems, "Toothbrush", 4.99, 10, 0.99);
          numOfItems++;
          itemList = addItem(itemList, numOfItems, "Deodorant", 1.45, 12, 1.05);
          
          
          // printing array
          printCart(itemList, 4);
          
          // removing toothpaste from array
          numOfItems = removeItem("Toothpaste", itemList, numOfItems);
          
          // printing array
          printCart(itemList, 3);
          
          // removing rest of array
          numOfItems = removeItem("Shampoo", itemList, numOfItems);
          numOfItems = removeItem("Toothbrush", itemList, numOfItems);
          numOfItems = removeItem("Deodorant", itemList, numOfItems);
          
          // printing array
          printCart(itemList, 0);
          
          // Adding 2 more items (same name but different prices)
          numOfItems++;
          itemList = addItem(itemList, numOfItems, "BookShelf", 19.99);
          numOfItems++;
          itemList = addItem(itemList, numOfItems, "BookShelf", 38.75, 10, 0.99);
          
          
          // printing array
          printCart(itemList, numOfItems);
          
          // removing non-existent item
          numOfItems = removeItem("Stove", itemList, numOfItems);
          
          // printing array
          printCart(itemList, numOfItems);
          
          // removing first element
          numOfItems = removeItem(itemList[0].getName(), itemList, numOfItems);
          
          // printing array
          printCart(itemList, numOfItems);
          
     }
     
     /** 
      @param  itemList - an item object array
      @param  numOfItems - represents the current number of objects you want in the array
     */
     // This method prints out what is current in the itemList array.
     public static void printCart(Item[] itemList, int numOfItems){
         System.out.println();
         
         if (itemList[0] == null){
            System.out.println("There are no items in the cart");
         } else {
            System.out.println("List of Items in the cart");
            for (int i = 0; i < itemList.length; i++){
               // break loop if it runs into null, toString cannot be called on null.
               if (itemList[i] == null) {
                  break;
               }
               System.out.println(itemList[i].toString());
            }
         }
         
         System.out.println();
     }
     
     /** 
      @param  itemList - an item object array
      @param  numOfItems - represents the current number of objects you want in the array
      @param  name - the name of the item you want to add to the array
      @param  price - the price for one quantity of the item added to array
      @return itemList - returns itemList updated with the new item
     */
     // This method is standard for adding regular items.
     public static Item[] addItem(Item[] itemList, int numOfItems, String name, double price){
         // if array is full expand with copyArray
         if (itemList.length < numOfItems){
            itemList = copyArray(itemList, numOfItems);
         }
         
         itemList[numOfItems - 1] = new Item(name, price);
         System.out.println("Added " + name + " " + price);
         return itemList;
     }
     
     /** 
      @param  itemList - an item object array
      @param  numOfItems - represents the current number of objects you want in the array
      @param  name - the name of the item you want to add to the array
      @param  price - the price for one quantity of the item added to array
      @param  bulk - represents the amount of quantity required to be eligible for bulk price
      @param  bulkPrice - represents the bulk price, usually cheaper
      @return itemList - returns itemList updated with the new item
     */
     // This method adds in an item which has a bulk price.
     public static Item[] addItem(Item [] itemList, int numOfItems,String name, double price,int bulk, double bulkPrice){
         // if array is full expand with copyArray
         if (itemList.length < numOfItems){
            itemList = copyArray(itemList, numOfItems);
         }
         
         itemList[numOfItems - 1] = new Item(name, price, bulk, bulkPrice);
         System.out.println("Added " + name + " " + price + " Bulk Item @ " + bulkPrice + " for " + bulk);
         return itemList;
     }
     
     /** 
      @param  itemName - represents the name of the item to remove from array
      @param  itemList - represents the current object array
      @param  numOfItems - represents the current number of objects you want in the array
      @return itemList - returns itemList updated with the new item
     */
     // This method removes an item from the array.
     public static int removeItem(String itemName, Item[] itemList, int numOfItems){
         boolean found = false;
     
         for (int i = 0; i < itemList.length; i++){
            if (itemList[i] != null && itemName.equals(itemList[i].getName())){
               // shifting from the starting point of when item found
               for (int j = i; j <itemList.length - 1; j++){
                  itemList[j] = itemList[j+1];
               }
               
               // proceed to remove last element
               itemList[itemList.length - 1] = null;
               numOfItems--;
               found = true;
               System.out.println("Removed item " + itemName);
            }       
         }
         
         if (found == false) { 
            System.out.println("Cannot remove " + itemName + " not in cart.");
         }
         
         
         return numOfItems;
     }
     
     /**
      @param  itemList - represents the current object array
      @param  numOfItems - represents the current number of objects you want in the array
      @return newList - returns the copied object array with an extra index
      @throws IllegalArgumentException if the itemList is empty or null
     */
     // This method copys the orginal array and adds another index to it according to the numOfItems desired.
     public static Item[] copyArray(Item[] itemList, int numOfItems){
         if (itemList == null){
            throw new IllegalArgumentException("Empty Array");
         }
          
         Item[] newList = new Item[numOfItems];
         System.arraycopy(itemList, 0, newList, 0, itemList.length);
         return newList;
     }
}