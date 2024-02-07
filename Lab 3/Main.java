import java.util.Random;
import java.util.Scanner;

public class Main {
   
   public static void main(String[] args){
      
      // testing area while developing object
      Random rand = new Random();
      int pickDirection = rand.nextInt(2)+1;
      
      RandomWalker walker1 = new RandomWalker();
      
      int y = walker1.getY();
      int x = walker1.getX();
      
      System.out.println("Start");
      System.out.println("y:" + y);
      System.out.println("x:" + x);
      
      
      Scanner console = new Scanner(System.in);
      int userInput = 0;
      
      while (userInput == 0 ){
         System.out.println("enter 0 to move, any number to exit");
         userInput = console.nextInt();
         
         System.out.println();
         // to confirm that x or y values change + or -1
         System.out.println("I moved");
         walker1.move();
         
         y = walker1.getY();
         x = walker1.getX();
         System.out.println("y:" + y);
         System.out.println("x:" + x);
         
         System.out.println();
         // testing steps method
         int steps = walker1.getSteps();
         System.out.println("Steps: " + steps);
         
         
      }
   }
}