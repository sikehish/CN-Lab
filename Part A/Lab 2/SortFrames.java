// Write a program to sort frames using appropriate sorting techniques 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class SortFrames{
    public static void main(String[] args){

         ArrayList<int[]> frames= new ArrayList<>();
         Random random = new Random();


        System.out.print("Enter number of frames:\t");
        Scanner sc= new Scanner(System.in);

        int n=sc.nextInt();

        System.out.print("\n--------\n");

        for(int i=0; i<n; i++ ){
            int seqNum = random.nextInt(500);
            int arr[]={i, seqNum};
            frames.add(arr);
        }

        System.out.println("Before Frame Sorting: ");
        for(int[] ele: frames){
            System.out.println("Frame "+ele[0]+" : "+ele[1]); //OR System.out.printf("Frame: %d : %d", ele[0], ele[1]);
        }
        System.out.print("\n--------\n");

        sortFrames(frames);

        System.out.println("After Frame Sorting: ");
        for(int[] ele: frames){
            System.out.println("Frame "+ele[0]+" : "+ele[1]); //OR System.out.printf("Frame: %d : %d", ele[0], ele[1]);
        }
        
    }

     private static void sortFrames(ArrayList<int[]> frames) {
        Collections.sort(frames, (a, b) -> Integer.compare(a[1], b[1]));
    }
}