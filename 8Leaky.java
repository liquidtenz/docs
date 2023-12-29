import java.util.*;

class LeakyBucket {

  public static  void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int no_of_queries = 4;
    int bucket_size = 10;
    int input_packet_size;
    int output_packet_size = 1;
    int stored_buffer_size = 0;
    int size_left;

    for (int i = 0; i < no_of_queries; i++) {
      System.out.println("Input Packet Size: ");
      input_packet_size = sc.nextInt();

      size_left = bucket_size - stored_buffer_size;

      if(input_packet_size <= size_left) {
        stored_buffer_size += input_packet_size; 
      }else {
        System.out.println("Packet Dropped");
      }
      System.out.println("Stored Buffer Size: "+ stored_buffer_size);
      stored_buffer_size -= output_packet_size;

    }

  }
}
