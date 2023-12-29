import java.util.*;

class Crc {

  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);

    String poly = "10000100001000010101";

    System.out.print("Enter Data to be sent: ");
    String data = sc.next();

    String rem = crc(data, poly, false);
    String codeword = data+rem;

    System.out.println("Remainder: " + rem);
    System.out.println("Codeword: " + codeword);

    System.out.print("Enter received codeword: ");
    String revCodeword = sc.next();

    String recvRem = crc(revCodeword, poly, true);

    if(Integer.parseInt(recvRem) == 0) 
    {
      System.out.print("No Error");
    }
    else  {
      System.out.print("Error Detected");
    }
  }

  public static String crc(String data, String poly, boolean errcheck) {
  
    StringBuilder rem = new StringBuilder(data);

    if(errcheck == false) {
      for(int i = 0; i < poly.length() - 1; i++) 
        rem.append("0");
    }

    for (int i = 0; i < rem.length() - poly.length()+1; i++) {
      if(rem.charAt(i) == '1') {
        for(int j = 0; j < poly.length(); j++) {
          rem.setCharAt(i+j, (rem.charAt(i+j) == poly.charAt(j)) ? '0': '1');
        }
      }
    }

    return rem.substring(rem.length() - poly.length() + 1);  
 }
}
