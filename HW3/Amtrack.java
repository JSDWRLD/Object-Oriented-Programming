import java.util.*;
import java.io.*;

class Amtrack{

   private Car front;

   public Car getFront(){
   
      return this.front;
      
   }
   
   public Amtrack(){
   
      front = null;
      
   }
       
   
   public  void  attachCar(String stopName,int carPosition,String schoolName) {
   
      Car current = new Car(stopName, carPosition, schoolName);
      
      Car temp;
      
      // if the front of the car is empty or the car position of the incoming car is less than front
      // we need to switch the nodes around, incoming next = current front
      // front = incoming node
      if(front == null || front.carPosition >= carPosition) {
         current.next = front;
         front = current;
      } else {
         
         // set front = temp so we dont change the front node
         temp = front;
         
         // iterate through list and place in order, stops once the position is less than the one infront of it
         while (temp.next != null && temp.next.carPosition < carPosition){
            temp = temp.next;
         }
         
         // reassign the current car's next to the pointer that temp node is pointing to
         // the temp node that it is pointing to is the one in front
         current.next = temp.next;
         // reassign the pointer of the temp node to the current car
         temp.next = current;
         
      }   
   }
   
   
   public boolean findCar(Car car){
      // search for the given car
      Car temp = front;
      
      while(temp != null){   
      
         // break loop we find car 
         if(temp.stopName.trim().equals(car.stopName) && temp.carPosition == car.carPosition &&
         temp.schoolName.trim().equals(car.schoolName)){
            return true;
         }
         
         // move to next node 
         temp = temp.next;
      }
      
      // false if reaches end and nothing found
      return false;
   }
   
   public  boolean detachCar(Car car) {
      // search for the given car, if found remove it from the train and return true
      Car temp = front;
      String stopName = car.stopName;
      int carPosition = car.carPosition;
      String schoolName = car.schoolName;
      
      // if front of car is one to detach
      if(front.stopName.trim().equals(stopName.trim()) && front.carPosition == carPosition &&
      front.schoolName.trim().equals(schoolName.trim())){
      
         front = front.next; 
         
         return true;
      }
      
      // while loop to check each cart after the first
      while(temp.next != null){
         
         if(temp.next.stopName.trim().equals(car.stopName)){
         
            Car carToDetach = temp;  
            temp = temp.next;      
            carToDetach.next = null;  
            
            return true;
         }
         
         temp = temp.next;
      }
      
      return false;
      // else return false
   }
   
   public void displayCars() {
   
      //iterate through the linkedlist from the head and display all the details of the car\
      Car temp = front;
      while(temp != null) {
         System.out.println(temp.toString());
         temp = temp.next;
      }
      System.out.println();
     
   }
     

   public void  mergeCars(Amtrack train2) {
      
      Car temp = front;
      Car tempTwo = train2.getFront();

      while (temp.next != null && tempTwo != null){
         
         if (temp.carPosition <= tempTwo.carPosition && temp.next.carPosition >= tempTwo.carPosition){
            attachCar(tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName);
            train2.detachCar(new Car (tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName));
            tempTwo = tempTwo.next;
         }
         
         // update current node
         temp = temp.next;
      }
      
      while (tempTwo != null){
         attachCar(tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName);
         train2.detachCar(new Car (tempTwo.stopName, tempTwo.carPosition, tempTwo.schoolName));
         tempTwo = tempTwo.next;
      }

   }
   
   /*
   
   public  void  attachCarToFront(String stopName,int carPosition,String schoolName){
      //write code to create a new car with the details that are given as input
   
      //attach this car to the train 
   
      //write code to create a new car with the details that are
      //given as input
      //attach this car to the front of the train;
 
   }
  
   public Amtrack reverseTrain() {
      // create a new train 
      // reverse the train here by repeatedly attaching the cars to the front of the new train.
  
    
   }
   
   */
   
   // given constructor that reads from a file and creates the train
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


  
  


