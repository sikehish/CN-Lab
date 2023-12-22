import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int src,num;
        System.out.println("Enter the number of vertices");
        num=sc.nextInt();

        int distance[] = new int[num];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // for (int i = 0; i < num; i++) {
        //     distance[i]=Integer.MAX_VALUE;
        // }
        
        System.out.println("Enter the source vertex");
        src=sc.nextInt();
        
        distance[src]=0;

        System.out.println("Enter the edge weights: ");
        int[][] graph = new int[num][num];
        for(int[] ele: graph){
            for(int i=0; i<num; i++){
                ele[i]=sc.nextInt();
            }
        }

        for (int i = 0; i < num; i++) { 
            for (int u = 0; u < num; u++) { 
              for (int v = 0; v < num; v++) { 
                if (graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) { 
                    distance[v] = distance[u] + graph[u][v]; 
                  } 
               } 
            } 
        }
        
        System.out.printf("Vertex \t Distance from Source(Node %d): \n", src); 
          for (int i = 0; i < num; i++) { 
            System.out.println((i + 1) + "\t\t" + distance[i]); 
            } 

    }
}


// Give the below graph as i/p:
// 0 5 0 0 0 0
// 0 0 1 2 0 0
// 0 0 0 0 1 0
// 0 0 0 0 0 2
// 0 0 0 -1 0 0
// 0 0 0 0 -3 0