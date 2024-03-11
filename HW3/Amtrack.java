import java.util.*;
import java.io.*;

class Amtrack{

   private Car front;

   public Car getFront(){
      return this.front;
   }
   
   public Amtrack(){
      front =null;
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
       
         
      displayCars();
      System.out.println();
   }
   /*
   public boolean findCar(Car car){
      // search for the given car
   }
   
   //remove a car
   public  boolean detachCar(Car car) {
      // search for the given car, if found remove it from the train and return true
      // else return false
   
   
   }
   */
   public void displayCars() {
   
      //iterate through the linkedlist from the head and display all the details of the car\
      Car temp = front;
      while(temp != null) {
         System.out.println(temp.toString());
         temp = temp.next;
      }
      
     
   }
   
     
   /*
   public void  mergeCars(Amtrack train2) {
   
   //perform merge operation on both the trains. Remember you should arrange the cars according to the carposition field.
   
   //note that you must use detach the cars from the second train during the merge operation.
    
   }
   
   public  void  attachCarToFront(String stopName,int carPosition,String schoolName){
   //write code to create a new car with the details that are given as input
   
   //attach this car to the train 
   
   //write code to create a new car with the details that are
   //given as input
   //attach this car to the front of the train;
 
   }
  
   public Amtrack reverseTrain() {
   // create a new train 
   //reverse the train here by repeatedly attaching the cars to the front of the new train.
  
    
   }
    
   //this must be performed only after merge operation. The cars are now in descending order
  
  

   */
   // given constructor that reads from a file and creates the train
   public Amtrack(String filename) {
       try {
             front =null;
             File myObj = new File(filename);
             Scanner fileReader = new Scanner(myObj);
             while (fileReader.hasNextLine()) {
               String data = fileReader.nextLine();
               String tokens[] = data.split(",");
               attachCar(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
             }
             //write code to call attach car in iterative manner
           //read each line from the file and process that line before processing next line
             fileReader.close();
   
           } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
           }
   }
   
}


  
  


