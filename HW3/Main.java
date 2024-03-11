// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
  
  public static void main(String[] args) {
  
      Amtrack sacramentoTrain = new Amtrack("sacramento.txt");
      sacramentoTrain.displayCars();
      
      Amtrack sanjoseTrain = new Amtrack("sanjose.txt");
      sanjoseTrain.displayCars();
      

      /*
      System.out.println(sacramentoTrain.findCar(new Car("Oakland",6, "Northeastern University in Oakland")));
      
      sacramentoTrain.detachCar(new Car("Oakland",6,"Northeastern University in Oakland"));
      sacramentoTrain.displayCars();
      
      */
      
      
      sacramentoTrain.mergeCars(sanjoseTrain);
      sacramentoTrain.displayCars();

      
  }
}
