/**
* @version 3-18-24
* Represents an Amtrak train composed of individual cars. Provides methods for manipulating the 
* train's structure and composition.
*/

import java.util.*;
import java.io.*;

class Amtrack{
   
   /**
    * Reference to the first car in the Amtrak train (the front of the train).
    */
   private Car front;
   
   /**
    * Gets the first car (front) of the train.
    *
    * @return The first Car object in the train.
    */
   public Car getFront(){
      return this.front;
   }
   
   /**
    *  Creates an empty Amtrak train.
    */
   public Amtrack(){
      front = null;
   }
       
   /**
    * Adds a new car to the train in its correct position based on 'carPosition'.
    *
    * @param stopName The name of the stop associated with the car.
    * @param carPosition The designated position of the car within the train.
    * @param schoolName The school associated with the car.
    */
   public  void  attachCar(String stopName,int carPosition,String schoolName) {
   
      Car current = new Car(stopName, carPosition, schoolName);
      
      Car temp;
      
      if(front == null || front.carPosition >= carPosition) {
         current.next = front;
         front = current;
      } else {
         
         temp = front;
         
         // iterate through list and place in order, stops once the position is less than the one infront of it
         while (temp.next != null && temp.next.carPosition < carPosition){
            temp = temp.next;
         }
         
         current.next = temp.next;
         temp.next = current;
         
      }   
   }
   
   /**
    * Searches for a car in the train based on stop name, position, and school name.
    *
    * @param car The Car object containing the details to search for.
    * @return True if the car is found in the train, false otherwise.
    */
   public boolean findCar(Car car){
      Car temp = front;
      
      while(temp != null){   
      
         if(temp.stopName.trim().equals(car.stopName) && temp.carPosition == car.carPosition &&
         temp.schoolName.trim().equals(car.schoolName)){
            return true;
         }

         temp = temp.next;
      }
      
      return false;
   }
   
   /**
    * Removes a specified car from the train.
    *
    * @param car The Car object representing the car to be removed.
    * @return True if the car was found and removed, false otherwise.
    */
   public  boolean detachCar(Car car) {
      // empty train
      if (front == null) {  
        return false;
      }
   
      Car temp = front;
      
      // Base case front node
      if(front.stopName.trim().equals(car.stopName.trim()) && front.carPosition == car.carPosition &&
      front.schoolName.trim().equals(car.schoolName.trim())){
      
         front = front.next; 
         return true;
      }
      

      // while loop to check each cart after the first
      while(temp.next != null){
         
         if(temp.next.stopName.trim().equals(car.stopName.trim()) && temp.next.carPosition == car.carPosition 
         && temp.next.schoolName.trim().equals(car.schoolName.trim())){

            Car prev = temp;  
            temp = temp.next;
            prev.next = temp.next;      

            return true;
         }
         
         temp = temp.next;
      }
      
      return false;
   }
   
   /**
    * Prints the details of all cars in the train.
    */ 
   public void displayCars() {
   
      Car temp = front;
      while(temp != null) {
         System.out.println(temp.toString());
         temp = temp.next;
      }
      System.out.println();
   }
     
   /**
    * Merges cars from another Amtrak train (train2) into the current train, maintaining order.
    *
    * @param train2 The Amtrak train from which to merge cars.
    */
   public void  mergeCars(Amtrack train2) {
      
      Car temp = front;
      Car tempTwo = train2.getFront();
      
      // does initial merge
      while (temp.next != null && tempTwo != null){
         
         if (temp.carPosition <= tempTwo.carPosition && temp.next.carPosition >= tempTwo.carPosition){
            
            attachCar(tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName);
            train2.detachCar(new Car (tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName));
            
            tempTwo = tempTwo.next;
         }
         
         // update current node
         temp = temp.next;
      }
      
      // attaches the rest of second train
      while (tempTwo != null){
      
         attachCar(tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName);
         train2.detachCar(new Car (tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName));
         tempTwo = tempTwo.next;
      }
   }
   
   
   /**
    * Attaches a new car to the very front of the train.
    *
    * @param stopName The name of the stop associated with the car.
    * @param carPosition The designated position of the car within the train.
    * @param schoolName The school associated with the car.
    */
   public void attachCarToFront(String stopName,int carPosition,String schoolName){
      //write code to create a new car with the details that are given as input
      Car toInsert = new Car(stopName, carPosition, schoolName);
      
      toInsert.next = front;
      front = toInsert; 

   }
   
   /**
    * Reverses the order of cars in the train.
    *
    * @return A new Amtrak train with the cars in reversed order.
    */
   public Amtrack reverseTrain() {
      Amtrack newTrain = new Amtrack();
      
      Car current = front;
      
      while(current != null){
         newTrain.attachCarToFront(current.stopName, current.carPosition, current.schoolName);
         current = current.next;
      }
  
      return newTrain;
   }
   
   /**
    *  Creates an Amtrak train from a file. Loads car details from the specified file and
    *  adds them to the train.
    *
    *  @param filename The name of the file containing car information follow format: stopName,carPosition,schoolName
    *  @throws FileNotFoundException If the specified file is not found.
    */
   public Amtrack(String filename) {
       try {
             front = null;
             File myObj = new File(filename);
             Scanner fileReader = new Scanner(myObj);
             
             while (fileReader.hasNextLine()) {
               String data = fileReader.nextLine();
               String tokens[] = data.split(",");
               
               // calls attachCar method and puts inside tokens
               attachCar(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
             }
             
             fileReader.close();
   
           } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
           }
   }
}


  
  


