/**
 *  @version 04-21-2024
 * This is the contact class required by the PhoneBook class.
 */
class Contact {
    /**
     * Private attributes for encapsulation
     */
    private String firstName;
    private String lastName;
    private long homeNumber;
    private long officeNumber;
    private String emailAddress;


    /**
     * This is the default constructor that requires 5 fields to be inputted.
     * @param firstName      This is a String type and contacts the first name of the contact to add.
     * @param lastName       This is a String type and contacts the last name of the contact to add.
     * @param homeNumber     This is a long type and contacts the home number of the contact to add.
     * @param officeNumber   This is a long type and contacts the office number of the contact to add.
     * @param emailAddress   This is a String type and contacts the email address of the contact to add.
     */
    public Contact(String firstName, String lastName, long homeNumber, long officeNumber, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeNumber = homeNumber;
        this.officeNumber = officeNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Getters simply return the value field.
     */
    public String  getFirstName(){
        return firstName;
    }

    public String  getLastName(){
        return lastName;
    }

    public long  getHomeNumber(){
        return homeNumber;
    }

    public long  getOfficeNumber(){
        return officeNumber;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * Setters change the value field.
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setHomeNumber(long homeNumber){
        this.homeNumber = homeNumber;
    }

    public void setOfficeNumber(long officeNumber){
        this.officeNumber = officeNumber;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     *  This is the default to string method which features formating for better user experience.
     */
    public String toString(){
        // width is 15 and left aligned to create column
        // if there is a 0 we format
        if(homeNumber == 0){
            return String.format("%-15s %-15s %-15s %-15s %s%n", firstName, lastName, "-", officeNumber, emailAddress);
        } else if (officeNumber == 0) {
            return String.format("%-15s %-15s %-15s %-15s %s%n", firstName, lastName, homeNumber, "-", emailAddress);
        }

        return String.format("%-15s %-15s %-15s %-15s %s%n", firstName, lastName, homeNumber, officeNumber, emailAddress);
    }

}