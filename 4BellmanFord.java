import java.util.*;

class BellmanFord {

  private static int N;
  private static int[][] graph = new int[255][255];


  public static void bellmanFord(int src) {
  
    int []dist = new int[N];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    for (int i = 0; i < N; i++) {
      for (int u = 0; u < N; u++) {
        for (int v = 0; v < N; v++) {
          if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
            dist[v] = dist[u] + graph[u][v];
          }
        }
      }
    }

    for (int u = 0; u < N; u++) {
      for (int v = 0; v < N; v++) {
        if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
          System.out.println("Negative weight cycle detected");
          return ;
        }
      }
    }
    
    printSolution(dist);
  }

  public static void printSolution(int[] dist) 
  {
    System.out.println("Vertex\tDistance from Souce");

    for(int i = 0; i < N; i++){
      System.out.println((i+1) + "\t" + dist[i]);
    }
  }   

  public static void main(String[] args){  

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of vertices: ");
    N = sc.nextInt();

    System.out.println("Enter the weight Matrix of Graph");

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        graph[i][j] = sc.nextInt();
      }
    }

    System.out.println("Enter the source vertex: ");
    int source = sc.nextInt();

    bellmanFord(source-1);
  }

}
