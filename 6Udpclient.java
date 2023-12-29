import java.util.*;
import java.io.*;
import java.net.*;

class Uclient {


  public static void main(String[] args) throws Exception {
    
    
    DatagramSocket dsocket = new DatagramSocket(4000);
    byte[] buffer;
    
    DatagramPacket dpacket;
    System.out.println("Received Message: ");
    
    while(true) {
      
      buffer = new byte[555];
      dpacket = new DatagramPacket(buffer, buffer.length);
      dsocket.receive(dpacket);

      String req = new String(buffer).trim();
      System.out.println(req);

      if(req.equalsIgnoreCase("exit")) {
        dsocket.close();
        break;
      }
       
    }

  }

}
