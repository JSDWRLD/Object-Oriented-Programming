


import java.io.*;
import java.util.*;

public class TopTenList {

    public final static int MAX = 10;

    // Data structure representing a node in the list
    private LinkNode front = null;
    private LinkNode current = null;
    private int count = 0;

    /**
     *  Creates an empty TopTenList.
     */
    public TopTenList() {
        front = null;
    }

    /**
     * Creates a TopTenList by reading song data from a file.
     * @param fileName The name of the file to read from.
     * @throws FileNotFoundException If the specified file cannot be found.
     */
    public TopTenList(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            count++;
            String name = file.nextLine().trim();
            LinkNode element = new LinkNode(count, name);

            if (front == null) {
                front = element;
                current = element;
            } else {
                current.setNext(element);
                current = element;
            }
        }
    }

    /** 
     * Prints the current Top Ten chart in a neatly formatted list.
     */
    void printChart() {
        System.out.println("\n***** TOP TEN CHART **********\n");
        current = front;
        for (int i = 1; i <= count; i++) {
            System.out.printf("%4d%26s\n", current.getPosition(), current.getSong());
            current = current.getNext();
        }
    }

    /**
     * Retrieves the song title at a given position in the chart.
     * @param position The position of the song (1-based).
     * @return The song title, or "ERROR" if the position is invalid.
     */
    String getSong(int position) {
        String name = "ERROR";
        LinkNode t = front;

        if (position < 1 || position > count) {
            return name;
        } else {
            for (int i = 1; i < position; i++) {
                t = t.getNext();
            }
            name = t.getSong();
            return name;
        }
    }

    /**
     * Finds the position (ranking) of a given song in the chart.
     * @param song The song title to search for.
     * @return The position (1-based) of the song, or 0 if the song is not found.
     */
    int getPosition(String song) {
        current = front;
        int pos = 0;
        while (current != null) {
            if (current.getSong().equalsIgnoreCase(song)) {
                pos = current.getPosition();
            }
            current = current.getNext();
        }
        return pos;
    }

    /**
     * Adjusts the positions of songs in the list, starting from a given point.
     * @param e The LinkNode to start from.
     * @param position The amount to adjust positions by (can be positive or negative).
     */
    void adjustPosition(LinkNode e, int position) {
        if (e != null) {
            while (e != null) {
                e.setPosition(e.getPosition() + position);
                e = e.getNext();
            }
        }
    }

    /**
     * Deletes a song from the chart at a specified position.
     * @param position The position of the song to delete 
     * @return True if the song was deleted, False if position is invalid
     */
    boolean deleteSong(int position) {
        
    
        LinkNode temp = front;
        LinkNode prev = null;
        
        if(front.position == position) {
            front = front.next;
            
            adjustPosition(temp, -1);
            count--;
            
            return true;
        }
        
        while(temp.next != null){
            if (temp.next.position == position){
                  prev = temp;
                  temp = temp.next;
                  prev.next = temp.next;
                  temp.next = null;
                  
                  adjustPosition(prev.next, -1);
                  count--;
                  
                  return true;
            }
            
            temp = temp.next;
        }
        
        
        return false;
    }

    /**
     * Inserts a song into the chart at a specified position.
     * @param position The position where to insert the song 
     * @param song The title of the song
     * @return True if the song was successfully inserted, False if the position is invalid
     * @throws IllegalArgumentException if the position is out of the 1-10 range
     */
    boolean insertSong(int position, String song) {
    
        if(position < 1 || position > 10){
            throw new  IllegalArgumentException("Please enter a number 1-10.");
        }
        
        LinkNode insert = new LinkNode(position, song);
        
        LinkNode temp = front;
        LinkNode forward = null;
        
        while (temp != null ){
            
            // FRONT
            if (position == 1){
               front = insert;
               front.next = temp;
               
               adjustPosition(front.next, 1);
               count++;
               
               return true;
            }
            
            // MIDDLE
            if(temp.position < position && temp.next != null && temp.next.position >= position){
               
               forward = temp.next;
               temp.next = insert;
               insert.next = forward;
               
               if (count > 10) deleteSong(11);
               
               adjustPosition(insert.next, 1);
               count++;
               
               return true;
            }
            
            // TAIL
            if (temp.next == null && position >= temp.position + 1) { 
               
                temp.next = insert;
                
                if (count > 10) {
                    deleteSong(11);
                } 
                
                adjustPosition(insert.next, 1);
                count++;
                
                return true;
            }
            
            temp = temp.next;
            
        }
        
        
        return false; 
    }

    /**
     * Moves a song from one position to another within the chart.
     * @param oldPosition Original position of the song 
     * @param newPosition Destination position of the song 
     * @return True if the move was successful, False otherwise
     * @throws IllegalArgumentException if either position is out of bounds
     */
    boolean moveSong(int oldPosition, int newPosition) {
    
        if( oldPosition > count || oldPosition < 1 || newPosition > count || newPosition < 1 ){
            throw new IllegalArgumentException("One of the sizes you inputted are out of bounds.");
        }
        
        String currentSong = getSong(oldPosition);
        deleteSong(oldPosition);
        insertSong(newPosition, currentSong);
        return true;
    }
}
