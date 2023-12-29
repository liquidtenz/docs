import java.util.*;

class Frame {

  public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    List<int[]> frames = new ArrayList<>();

    System.out.println("Enter no of frames");
    int n = sc.nextInt();

    Random rc = new Random();

    for(int i = 0; i < n; i++) {
      System.out.println("Enter the data from the Frame");
      frames.add(new int[]{rc.nextInt(10000), sc.nextInt()});
    }

    System.out.println("\n\nBefore Sorting");
    System.out.println("Seq\tData");
    for(int[] i: frames) {
      System.out.printf("%d\t%d\n", i[0], i[1]);
    }

    Collections.sort(frames, (a,b) -> Integer.compare(a[0], b[0]));

    System.out.println("After Sorting");

    System.out.println("Seq\tData");
    for(int[] i:frames){
      System.out.printf("%d\t%d\n", i[0], i[1]);
    }
  }

}
