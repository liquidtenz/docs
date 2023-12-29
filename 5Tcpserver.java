import java.util.*;
import java.io.*;
import java.net.*;

class TcpServer {
  
  public static void main(String[] args) throws Exception {

    ServerSocket serverSocket = new ServerSocket(4000);
    System.out.println("Server Stared and waiting for clients");
    
    Socket sock = serverSocket.accept();

    System.out.println("Connect successful waiting for filename");
    InputStream istream = sock.getInputStream();
    
    BufferedReader nameRead = new BufferedReader (new InputStreamReader(istream));
    String filename = nameRead.readLine();

    OutputStream ostream = sock.getOutputStream();
    PrintWriter pwriter = new PrintWriter(ostream, true);

    try {

     BufferedReader content = new  BufferedReader(new FileReader(filename));
      String str;

      while((str = content.readLine())!= null){
        pwriter.println(str);
      }

      content.close();

    } catch(FileNotFoundException e){
      pwriter.println("File does not exits");
    }
    finally {
      System.out.println("Closing Connection");
      pwriter.close();
      nameRead.close();
      sock.close();
      serverSocket.close();
    }


  }
}
