import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*Enter your code here. Read input from STDIN. Print output to STDOUT. Your                class should be named Solution.*/
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Arraylist[] pilot = new Arraylist[n];
        for(int i = 0; i < n; i++){
            while(s.hasNextInt()){
                pilot[i].add(s.nextInt());
            }
        }
        int q = s.nextInt();
        for(int i=0;i<q;i++){
            x=in.nextInt();
            y=in.nextInt();
            System.out.println(pilot[x-1].get(y-1));
        }

    }
}
