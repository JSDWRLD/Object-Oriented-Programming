


class Main {
     
     // This is the size of the answer list you want
     public static final int SIZE = 20;
    
     // This main method is to be used in conjuction with the helper file.
     public static void main(String[] args) {
          String [] answers = new String[SIZE];
          int count = MagicBallHelper.readAnswers(answers);
          MagicBallHelper.playGame(answers,count);
       
     }
}