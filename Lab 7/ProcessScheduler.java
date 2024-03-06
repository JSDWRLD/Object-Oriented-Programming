
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

/**
* Program that reads tasks from file tasks.txt and schedules them for execution.
*
* @author John Dong
* @version 03/06/2024
*/
public class ProcessScheduler {

    /**
    * This is the main method which calls the run method
    */
    public static void main(String[] args) {
         run();
    }
    
    /**
    * This is the run method which acts as the driver for the program and uses the task class
    */
    public static void run() {
          try {
            Scanner reader = new Scanner(new File("tasks.txt"));
            Task[] taskList = new Task[20];
            int index = 0;
            int total = 0;
            
            Stack<Task> highPriority = new Stack<Task>();
            Queue<Task> lowPriority = new LinkedList<Task>();

            while (reader.hasNextLine()) {
            
                String line = reader.nextLine(); 
                String[] tokens = line.split(", ");
                int taskId = Integer.parseInt(tokens[0]);
                int priorityLevel = Integer.parseInt(tokens[1]);
                int executionTime = Integer.parseInt(tokens[2]);
                
                taskList[index] = new Task(taskId, priorityLevel, executionTime);
                
                if (priorityLevel == 1 || priorityLevel == 2){
                     highPriority.push(taskList[index]);
                } else {
                     lowPriority.add(taskList[index]);
                }
                index++;
                
            }
            
            reader.close();

            
            // Process tasks in the stack
            System.out.println("Executing tasks in the following order:");
            for(Task current : highPriority){
               total += current.getExecutionTime();
               System.out.println("Task " + current.getTaskId() + ", Execution Time: " + current.getExecutionTime());
            }
            

            // Process tasks in the queue
            for(Task current : lowPriority){
               total += current.getExecutionTime();
               System.out.println("Task " + current.getTaskId() + ", Execution Time: " + current.getExecutionTime());
            }
            
            highPriority.clear();
            lowPriority.clear();
            System.out.println("Total Execution Time: " + total);
                        
        } catch (FileNotFoundException e) { 
            System.err.println("File not found: tasks.txt"); 
        }      
    }
}


/**
* This is the Task Class
* 
*/
class Task {
    // private attributes
    private int taskId; 
    private int priorityLevel; 
    private int executionTime;

    /**
    * This is the constructor that takes in 3 parameters
    * @param taskId        this is the id number for the task
    * @param priorityLevel this is the level of priority of the task
    * @param executionTime this is how long it takes the task to be executed 
    */
    public Task(int taskId, int priorityLevel, int executionTime) {
       this.taskId = taskId;
       this.priorityLevel = priorityLevel;
       this.executionTime = executionTime;
    }
      
    /**
    * This is method returns the task ID
    * @return taskId        this is the id number for the task
    */
    public int getTaskId() {
        return taskId;
    }
          
    /**
    * This is method returns the prioritylevel
    * @return priorityLevel this is the level of priority of the task
    */
    public int getPriorityLevel() {
        return priorityLevel;
    }
   
    /**
    * This is method returns the time it takes to execute
    * @return executionTime this is how long it takes the task to be executed 
    */
    public int getExecutionTime() {
        return executionTime;
    }
}
