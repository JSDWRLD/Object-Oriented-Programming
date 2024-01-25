
import java.io.*;
import java.util.*;

class MagicBallHelper{
   
   // This method takes in a empty array and fills it up with answers and returns a int count.
   public static int  readAnswers(String [] answers){
     int count = 0; 
     File input = new File("answers.txt");
     
     try{
         Scanner fileReader = new Scanner(input);
         while (fileReader.hasNextLine() && count < answers.length ) {
              answers[count] = fileReader.nextLine();
              count++;
         }
     }
     catch(FileNotFoundException e){
         System.out.println("Error: Data file Not Found");
     }
     return count;
   }
   
   // This method runs the entire game, it checks the users input to see if it is a question or to exit. 
   // Method also calls postReply method to post a response to user input.
   public static void playGame(String []answers, int count){
     String input = "";
     Scanner console = new Scanner(System.in);
     
     System.out.println("Please enter your question or Quit to exit.");
     input = console.nextLine();
     
     while (!input.equalsIgnoreCase("quit")) {
         postReply(answers , count);
         System.out.println("Please enter your question or Quit to exit.");
         input = console.nextLine();
         
     }
     
   }
   
   // This method randomly generates an index and searches the answers array for a corresponding string.
   public static void postReply(String [] answers, int count){
        Random rand = new Random();
        int randomIndex = rand.nextInt(count-1);
        System.out.println(answers[randomIndex]);
   }  
}