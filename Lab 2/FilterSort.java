/* 
   
   1/31/24
   Lab 2: This program reads integer tokens from file, stores it in an array, and prints out the elements.
*/

import java.io.*;
import java.util.*;


public class FilterSort {
   
    // This method doubles the array passed in as a parameter.
    public static int[] doubleArrayAndCopy(int[] arr) {
       int length = arr.length;
       int[] temp = new int[length*2];
       
       for (int i = 0; i < arr.length; i++){
         temp[i] = arr[i];
       }
    
       return temp;
    }
    
    // This method is the main run of the program and calls doubleArrayAndCopy method.
    public static void runProgram(){
       // creating data array
       int[] data = new int[8];
       
       // try and catch to make sure we find file.
       try {
          Scanner input = new Scanner(new File("data.txt"));
          int index = 0;
          
          // while loop continues as long as we have the next token.
          while (input.hasNext()){ 
            // if statement checks if we have an integer token.
            if (input.hasNextInt()){
               int tempInt = input.nextInt();
               
               // stores integer token into data array and corresponding index.
               data[index] = tempInt;
               index++;
               
               // if data array's length goes over the current index we call the double method.
               if ( data.length <= index ){
                  data = doubleArrayAndCopy(data);
               }
               
            } else {
              // consuming left over tokens that are not integers.
              input.next();
            }    
          }
          
          // this sections sorts and prints only integer elements to the console. 
          if(index ==0){
            System.out.println("There is no data in file"); 
          } else {
            Arrays.sort(data, 0, data.length);
            for( int i = 0; i < data.length; i++ ){
               if (data[i] > 0 || data[i] < 0) {
                  System.out.println(data[i]);
               }
            }
          }
          
       } catch(FileNotFoundException e){
         System.out.println("Error: Data file not found");
       }
    }
    
    // Main method 
    public static void main(String[] args) {
       runProgram();
    }
}