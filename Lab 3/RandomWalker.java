


import java.util.Random;

class RandomWalker {
   
   // declaring private attributes
   private int y;
   private int x;
   private int steps;
   
   /** 
   Class constructor:  One class Constructor, default starting position (x,y) of (0,0)
   */
   public RandomWalker(){
      y = 0;
      x = 0;
      steps = 0;
   }
   
   /** 
   @description uses Random class to randomly generate a number and pick x or y according.

   */
   public void move(){
   
      Random rand = new Random();
      
      // pick x or y at random 1 for x, 2 for y
      int pickDirection = rand.nextInt(4);
      
      switch(pickDirection){
         case 0:
            x += 1;
            break;
         case 1: 
            x -= 1;
            break;
         case 2:
            y += 1;
            break;
         case 3:
            y -= 1;
            break;
      }
      // down y = -1, up y = 1
      // left x = -1, right x = 1
      
      steps++;
   }
   
   /** 
   @return return x coordinate
   
   */
   public int getX(){
      return x;
   }
   
   /** 
   @return return y coordinate
   
   */
   public int getY(){
      return y;
   }
   
   /** 
   @return return steps
   
   */
   public int getSteps(){
      return steps;
   }
}
