import java.util.Arrays;


/**
 * This is the SmartStringList class that has 2 attributes, the list and a boolean value to 
 * see if the list is sorted or not.
 */
class SmartStringList {
    private String[] list;
    private boolean sorted;

    public SmartStringList(int capacity){
        list = new String[capacity];
        sorted = true;
    }

    public void add(String s){
        int lastIndex = list.length - 1;
        if(list[lastIndex] != null) {
            list = Arrays.copyOf(list, list.length + 1);
            lastIndex = list.length - 1;
        } 
        list[lastIndex] = s;
        if(list.length > 1 && list[lastIndex - 1] != null){
            if(list[lastIndex - 1].compareToIgnoreCase(list[lastIndex]) > 0){
                sorted = false;
            }
        }
        
    }
    /**
     *  This method simply gets the string at the inputed index
     *  @param i  This is the index that the user wants to grab the string from.
     *  @return   The return value is the string if found.
     *  @throws IllegalArguementException This exception is thrown if a invalid index is inputted.
     */
    public String get(int i){
        if(i >= list.length || i < 0) throw new IllegalArgumentException("Invalid index");
        return list[i];
    }
    /**
     *  This method only does a binary search if "sorted is true"
     *  @param s  This is the string a user wants to look for
     *  @return   The return value is the current index of the string if found. -1 if not found.
     */
    public int indexOf(String s){
        if(sorted){
            // binarySearch
            int start = 0;
            int end = list.length - 1;

            while(start <= end){
                int middle = (start + end) / 2;
                if(list[middle].compareToIgnoreCase(s) == 0) {
                    return middle;
                } else if (list[middle].compareToIgnoreCase(s) < 0) {
                    // go right 
                    start = middle + 1;
                } else {
                    // go left
                    end = middle - 1;
                }
            }

            return -1;
        } else {
            for(int i = 0; i < list.length; i++){
                if(list[i].compareToIgnoreCase(s) == 0) return i;
            }

            return - 1;
        }
    }

    /**
     *  This method does a seleciton sort and sets sorted to True once finished
     */
    public void sort(){
        int n = list.length;

        for(int i = 0; i < n -1; i++){
            
            int minIndex = i;
            for(int j = i+1; j < n; j++){
                if(list[j].compareToIgnoreCase(list[i]) < 0) {
                    minIndex = j;
                }
            }

            // swapping after exiting the min to i index
            String temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }

        sorted = true;
    }
}