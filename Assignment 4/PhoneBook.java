import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *  @version 04-21-2024
 *  This is the PhoneBook class which contains our contacts list and methods to
 *  Search, Add, Sort by First Name, and Sort by Last Name.
 */
class PhoneBook {
    public ArrayList<Contact> contacts;

    /**
     *  Default constructor for our contacts arraylist
     *  This constructor uses a scanner to reader a file by the name of ContactDetails.txt.
     *  @throws FileNotFoundException This exception will be thrown if a invalid pathname is inputed.
     *  Data file should be in the source folder with name "ContactDetails.txt" case sensitive.
     */
    public PhoneBook(){
        contacts = new ArrayList<>();

        try {
            Scanner dataReader = new Scanner(new File("ContactDetails.txt"));

            while(dataReader.hasNext()){
                String toSplit = dataReader.next();
                String[] tokens = toSplit.split(",");

                String firstName = tokens[0];
                String lastName = tokens[1];
                
                // for homeNumber
                long homeNumber = 0;
                if(!tokens[2].equals("-")){
                    homeNumber = Long.parseLong(tokens[2]);
                } 

                // for officeNumber
                long officeNumber = 0;
                if(!tokens[3].equals("-")){
                    officeNumber = Long.parseLong(tokens[3]);
                } 

                String emailAddress = tokens[4];

                Contact current = new Contact(firstName, lastName, homeNumber, officeNumber, emailAddress);
                contacts.add(current);
            }

            dataReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Data was not found");
        }
    }

    /**
     *  This method allows use to pass a contact to be added to the contacts array list.
     *  @param c  This is the contact user passes as a parameter, must already be created.
     */
    public void add(Contact c){
        contacts.add(c);
    }

    /**
     *  This method prints out our contacts ArrayList in formatted, columned form.
     */
    public String toString(){
        // header for the string
        String phoneBookString = String.format("%-15s %-15s %-15s %-15s %s%n", "FirstName", "LastName", "HomeNumber", "OfficeNumber", "EmailAddress");
        
        Iterator<Contact> searchList = contacts.iterator();

        // iterate through our contacts list and concat
        while(searchList.hasNext()){
            Contact curr = searchList.next();
            phoneBookString += curr.toString();
        }

        return phoneBookString;
    }

    /**
     *  This method sorts the contacts arraylist by first name
     */
    public void bubbleSort(){
        // two nested for loops
        for(int i = 0; i < contacts.size(); i++){
            for(int j = i+1; j < contacts.size(); j++){
                // if firstName of index j < firstName of index i switch
                if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName()) < 0) {
                    // System.out.println("Sorting " + "j: " + j + " " + contacts.get(j).getFirstName() + " less than " + "i: " + i + " " +contacts.get(i).getFirstName());
                    Contact temp = contacts.get(i);
                    contacts.set(i, contacts.get(j));
                    contacts.set(j, temp);
                }
            }
        }
    }

    /**
     *  This method sorts the contacts arraylist by last name
     */
    public void selectionSort(){
        // selection sort works because we can sort by min
        int length = contacts.size();

        for(int i = 0; i < length; i++){
            int minIndex = i;
            for(int j = i + 1; j < length; j++){
                // this returns a number, 0 is equal, < 0 means j < minIndex, vice versa
                if(contacts.get(j).getLastName().compareTo(contacts.get(minIndex).getLastName()) < 0){
                    minIndex = j;
                }
            }

            // once we finish iterating, we have the minimum, now we swap the positions
            // we continue iterating using i and sort the positions one by one
            Contact temp = contacts.get(minIndex);
            contacts.set(minIndex, contacts.get(i));
            contacts.set(i, temp);
        }
    }

    /**
     *  This method searches our contacts arraylist for a specific name and
     *  returns true or false to indicate if found or not
     *  @param name  This is the name user wants to find
     *  @return      True: Found Name, False: Not Found
     */
    public boolean binarySearch(String name){
        int start = 0;
        int end = contacts.size() - 1;

        while(start <= end){
            int middle = (start + end)/2;

            if(name.compareToIgnoreCase(contacts.get(middle).getLastName()) == 0){
                return true;
            } else if (name.compareToIgnoreCase(contacts.get(middle).getLastName()) < 0){
                // basically if the name we are looking for is less than the middle
                // go left
                end = middle - 1;
            } else {
                // name to find > middle
                // go right
                start = middle + 1;
            }
        }

        // if we iterate the entire tree and dont find it, then we return false
        return false;
    }
}
