
class Car {

     String stopName;
     int carPosition;
     String schoolName;
     Car next;
     
     Car(){
       this.stopName = "";
       this.carPosition = 0;
       this.schoolName = "";
       //default constructor
     }
 
     Car(String stopName,int carPosition,String schoolName){
       //regular constructor where you set next to null
       this.stopName = stopName;
       this.carPosition = carPosition;
       this.schoolName = schoolName;
     
     }
     
     public int getCarposition(){
       return this.carPosition;
     }
     
     public String getStopName(){
       return this.stopName;
     }
     
     public String getSchoolName(){
       return this.schoolName;
     }
     
     public void setNext(Car next){
       this.next = next;
     }
     
     public String toString() {
        return carPosition + "||" + schoolName + "||" + stopName;
     }
}
