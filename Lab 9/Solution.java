/**
 *  
 *  @version 3-27-24
 *  This is the solution to the prompt on Lab 9 which asks for a recursive method
 *  for check if a string is the same, case insensitive.
 */
class Solution {
    public static void main(String[] args){
        String s1 = "Hello";
        String s2 = "hello";
        System.out.println(isSame(s1, s2));
    }

    /**
     *  This method is recursive, each time we make another call we move the string
     *  forward by one so that the first index is always moved up
     *  we continue checking the letters and return false if they are not the same at any point.
     * 
     * @param s1  This parameter is the first string to be compared
     * @param s2  This is the second string to be compared to the first
     * @return    returns a boolean value, true if string is the same, false if not the same at any point
     */
    public static boolean isSame(String s1, String s2){
        // base case when both of their length == 0 true
        // if there length are same we run check
        // else not same length return false
        if(s1.length() == 0 && s2.length() == 0){
            // base case! we checked all letters without exiting false
            return true;
        } else if (s1.length() == s2.length()){
            // checking string we can use substring and char comparison
            char s1Letter = s1.charAt(0);
            char s2Letter = s2.charAt(0);
            if(Character.toLowerCase(s1Letter) == Character.toLowerCase(s2Letter)){
                // continue check rest of letter
                // by doing this we keep moving the 0 index forward until base case
                return isSame(s1.substring(1), s2.substring(1));
            } else {
                // chars at 0 index are not same return false
                return false;
            }
        } else {
            return false;
        }
    }
}