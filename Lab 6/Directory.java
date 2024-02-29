
import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

/**
* Standard Directory class with its respective methods
*/
public class Directory {
   
   // private directory hashmap
   private HashMap<String, String> directory;
   
   /**
    * Constructs a Directory object and initializes the directory hashmap by reading from the specified file.
    *
    * @param file the name of the file containing directory information
    * @throws FileNotFoundException if the parameter file is not found
   */
   public Directory(String file) throws FileNotFoundException  {
         directory = new HashMap<String, String>();
         
         Scanner reader = new Scanner(new File(file));
         
         while(reader.hasNext()) {
            String inline = reader.nextLine();
            String[] inlineSplit = inline.split(":");
            directory.put(inlineSplit[0], inlineSplit[1]);
         }
         reader.close();
   }
   
   
   /**
    * Retrieves the phone number associated with the specified name from the directory.
    *
    * @param name the name associated with phone number to retrieve
    * @return the phone number associated with the specified name, or an empty string if the name is not found
   */
   public String getPhoneNumber(String name) {
      if(directory.containsKey(name)){
         return directory.get(name);
      } else {
         return "";
      }
   }
   
   /**
    * Deletes the entry associated with the specified name from the directory.
    *
    * @param name the name to delete from directory
   */
   public void delete(String name){
      directory.remove(name);
      System.out.println(name + " Removed");
   }
   
   /**
    * Adds a new entry with the specified name and phone number to the directory.
    *
    * @param name the name to add to directory
    * @param number the phone number associated with the name
   */
   public void add(String name, String number){
      directory.put(name, number);
      System.out.println("Adding \t" + name + "\t" + number);
   }
   
   /**
    * Changes the phone number associated with the specified name in the directory.
    *
    * @param name the name to change
    * @param number the new phone number to associate with the specified name
   */
   public void change(String name, String number){
      directory.replace(name, number);
      System.out.println("Changing " + name + "\t" + number);
   }
   
   /**
    * Displays all entries in the directory.
   */
   public void displayDirectory(){
      for(String name : directory.keySet()){
         System.out.printf("%20s%16s%n", name, directory.get(name));
      }
   }

}