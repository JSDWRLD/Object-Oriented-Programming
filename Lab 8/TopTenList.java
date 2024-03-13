import java.io.*;
import java.util.*;

public class TopTenList{
public final static int MAX=10;
private
LinkNode front=null;
LinkNode current=null;
int count=0;
  public TopTenList(){
   front=null;
  }
  public TopTenList(String fileName)throws FileNotFoundException{
    Scanner file = new Scanner (new File(fileName));
    while (file.hasNextLine()){
      count++;
      String name=file.nextLine().trim();
      LinkNode element = new LinkNode(count,name);
      //System.out.println(name);
      if (front ==null )
         {
           front= element;
           current=element;
         }
      else current.setNext(element);
      current=element;
      //System.out.println(current.getSong());
    }

  }
  void printChart(){
    System.out.println("\n***** TOP TEN CHART **********\n");
    current=front;
    for (int i=1;i<=count;i++){    
      System.out.printf("%4d%26s\n",current.getPosition(),current.getSong());
      current = current.getNext();
    }
  }

 String getSong(int position){
   String name ="ERROR";
   LinkNode t =front;
    if (position <1 || position > count)
     return name;
    else {
      for (int i=1;i<position;i++)
          t=t.getNext();
      name = t.getSong();
      return name;
    }
 }
 int getPosition(String song){
   current =front;
   int pos =0;
   while(current!=null){
      if (current.getSong().equalsIgnoreCase(song))
          pos = current.getPosition();
      current=current.getNext();
   }
      
   return pos;
 }
 void adjustPosition(LinkNode e,int position){
   if (e!=null)
    while (e!=null){
      e.setPosition(e.getPosition()+position);
      e=e.getNext();
    }
 }
 boolean deleteSong(int position){
   //insert code here;
   return true;
 }
 boolean insertSong(int position,String song){
  //insert your code here
  return true; //change this as needed

 }
 boolean moveSong(int oldPosition, int newPosition){
   //insert your code here
   return true; //change this as needed
 }

}