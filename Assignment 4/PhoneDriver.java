import java.util.Scanner;

/**
 *  @version 04-21-2024
 *  This is the PhoneDriver class meant to be used in coorelation with the PhoneBook class
 *  and the Contact class, prior to running ensure you have a ContactDetails.txt file in the source folder.
 */
public class PhoneDriver {
    /**
     * This is the main method of the PhoneDriver class.
     * @param args  No arguments being passed.
     */
    public static void main(String[] args) {
        PhoneBook test = new PhoneBook();
        menus(test);
    }

    /**
     * This method is the main driver, it calls another method called printMenu
     * and does the majority of the decision making depending on user input.
     * @param phonebook This parameter must be passed in order for there to be a phonebook to utilize.
     */
    public static void menus(PhoneBook phonebook){
        printMenu();
        Scanner console = new Scanner(System.in);
        String choice = console.next();
        while(!choice.equalsIgnoreCase("Q")){
            switch (choice) {
                case "P", "p":
                    System.out.println(phonebook.toString());
                    break;
                case "B", "b":
                    phonebook.bubbleSort();
                    break;
                case "L", "l":
                    phonebook.selectionSort();
                    break;
                case "S", "s":
                    System.out.println("Enter contact's last name to searched: ");
                    String lookFor = console.next();
                    boolean status = phonebook.binarySearch(lookFor);
                    if(status){
                        System.out.println("Contact Found");
                    } else {
                        System.out.println("Contact Not Found");
                    }
                    break;
                case "A", "a":
                    System.out.print("Input contact First Name: ");
                    String firstName = console.next();
                    System.out.print("Input contact Last Name: ");
                    String lastName = console.next();
                    System.out.print("Input contact Home Number: ");
                    long homeNumber = console.nextLong();
                    System.out.print("Input contact Office Number: ");
                    long officeNumber = console.nextLong();
                    System.out.print("Input contact Email Address: ");
                    String email = console.next();

                    Contact toAdd = new Contact(firstName, lastName, homeNumber, officeNumber, email);
                    phonebook.add(toAdd);
                    break;
                case "Q", "q":
                    System.out.println("Good Bye!");
                    break;
                default:
                    break;
            }

            printMenu();
            choice = console.next();
            System.out.println();
        }

        console.close();
    }

    /**
     *  This method simply prints out the menu of choices for the user to see.
     */
    public static void printMenu(){
        // Print menu
        System.out.println("P: Print Phonebook");
        System.out.println("B: Sort phone book by first name");
        System.out.println("L: Sort phone book by last name");
        System.out.println("S: Search contact by last name");
        System.out.println("A: Add contact to phone book");
        System.out.println("Q. Quit");
        
    }
}
