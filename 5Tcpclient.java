import java.util.*;
import java.net.*;
import java.io.*;

class Tcpclient {

  public static void main(String[] args) throws Exception {

    Socket sock = new Socket("127.0.0.1", 4000);

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the filename: ");
    String filename = sc.nextLine();

    OutputStream ostream = sock.getOutputStream();
    PrintWriter pwrite = new PrintWriter(ostream, true);
    pwrite.println(filename);

    InputStream istream = sock.getInputStream();
    BufferedReader content = new BufferedReader(new InputStreamReader(istream));

    String str;

    while((str = content.readLine()) != null) {
      System.out.println(str);
    }

    content.close();
    pwrite.close();
    sock.close();
    sc.close();

  }

}

