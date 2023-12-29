import java.util.*;
import java.math.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

class Rsa {

  private BigInteger p, q, N, phi, e, d;
  private int bitLength = 1024;
  private Random r;

  public Rsa() {
  
    r = new Random();
    p = BigInteger.probablePrime(bitLength, r);
    q = BigInteger.probablePrime(bitLength, r);

    N = p.multiply(q);
    
    phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    e = BigInteger.probablePrime(bitLength/2, r);

    while ( phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) {
      e = e.add(BigInteger.ONE);
    }

    System.out.println("Public Key is " + e);
    d = e.modInverse(phi);
    System.out.println("Private Key is " + d);
  }

  public static void main(String[]  args) {
    Rsa rsa = new Rsa();

    Scanner sc =  new Scanner(System.in);

    System.out.println("Enter the plain text");
    String plainTest = sc.nextLine();
  
    System.out.println("Encrypting String: "+ plainTest);
    System.out.println("String in bytes: " + bytesToString(plainTest.getBytes()));

    byte[] encrypted = rsa.encrypt(plainTest.getBytes());
    byte[] decrypted = rsa.decrypt(encrypted);
    System.out.println("Encrypted Bytes: " + bytesToString(encrypted));
    System.out.println("Decrypted Bytes: " + bytesToString(decrypted));
    System.out.println("Decrypted String: " + new String(decrypted, StandardCharsets.UTF_8));

  }

  private static String bytesToString(byte[] encrypted){
    StringBuilder result = new StringBuilder();
    for(byte b: encrypted) {
      result.append(Byte.toString(b));
    }
    return result.toString();
  }
  
  public byte[] encrypt(byte[] message){
    return (new BigInteger(message)).modPow(e, N).toByteArray();
  }

  public byte[] decrypt(byte[] message){
    return (new BigInteger(message)).modPow(d, N).toByteArray();
  }

}
