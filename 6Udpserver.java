import java.util.*;
import java.io.*;
import java.net.*;

class Userver {
  
  public static void main(String[] args) throws Exception {
  
    Scanner in = new Scanner(System.in);
    DatagramSocket dsocket = new DatagramSocket();
    InetAddress clientAddress = InetAddress.getByName("127.0.0.1");
    
    String message;
    byte[] buffer;
    DatagramPacket dpacket;
    
    System.out.println("Enter the message to send: ");
    
    while(true) {
    
      message = in.nextLine();
      buffer = message.getBytes();
      dpacket = new DatagramPacket(buffer, buffer.length, clientAddress, 4000);
      dsocket.send(dpacket);

      if(message.equalsIgnoreCase("exit")) {
        dsocket.close();
        break;
      }

    }
  }

}
