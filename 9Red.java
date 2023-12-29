import java.util.*;

class Red {
  
  static final int MAX_PACKET = 20;
  static final int QUEUE_SIZE = 10;
  static final double MAX_PROB = 0.7;
  static final double MIN_PROB = 0.3;
  
  public static void main(String[] args) {
  
    Random rc = new Random();
    int queue_length = 0;
    
    double dropProb = MIN_PROB;
    
    for (int i = 0; i < MAX_PACKET; i++) {
       
      if(queue_length == QUEUE_SIZE) {
        System.out.println("Packet Dropped (Queue Full)");
        dropProb = MIN_PROB;
      }
      else if ((double) rc.nextDouble() < dropProb) {
        System.out.println("Packet Dropped (Random) ");
        dropProb += (MAX_PROB - MIN_PROB) / (MAX_PACKET - 1);
      }
      else {
        System.out.println("Packet Accepted");
        queue_length++;
        dropProb = MIN_PROB;
      }
       
    }
     
  }
}
