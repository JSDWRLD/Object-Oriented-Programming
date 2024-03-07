/* 
   Write a method copyStack that takes a stack of integers as a parameter and 
   returns a copy of the original stack (i.e., a new stack with the same values 
   as the original, stored in the same order as the original). Your method should 
   create the new stack and fill it up with the same values that are stored in 
   the original stack. It is not acceptable to return the same stack passed to 
   the method; you must create, fill, and return a new stack.
   
   You will be removing values from the original stack to make the copy, but 
   you have to be sure to put them back into the original stack in the same order 
   before you are done. In other words, when your method is done executing, the 
   original stack must be restored to its original state and you will return 
   the new independent stack that is in the same state. You may use one queue 
   as auxiliary storage.
*/

import java.util.*;

class Main {

   public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);
        // 1, 2, 3 stack TOP
        // queue has 3, 2, 1
        // queue remove gets in 

        Stack<Integer> copiedStack = copyStack(stack);
        System.out.println("Original Stack: " + stack);
        System.out.println("Copied Stack: " + copiedStack);
   }
   
   public static Stack<Integer> copyStack(Stack<Integer> stack) {
        Stack<Integer> queue = new Stack<>();
        Stack<Integer> result = new Stack<>();
        
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        
        while (!queue.isEmpty()) {
            
            int current = queue.pop();
            result.push(current);
            stack.push(current);
        }
        
        return result;
    }
}