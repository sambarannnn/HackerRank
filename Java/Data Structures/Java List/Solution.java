import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> l = new ArrayList<Integer>();
        while(n-->0){
            l.add(input.nextInt());
        }
        int q = input.nextInt();
        while(q-->0){
            String query = input.next();
            if(query.equals("Insert")){
                //System.out.println("yes");
                int index = input.nextInt();
                //System.out.println(index);
                //input.nextLine();
                int element = input.nextInt();
                //System.out.println(element);
                l.add(index, element);
            }
            else if(query.equals("Delete")){
                int index = input.nextInt();
                //System.out.println(index);
                l.remove(index);
            }
        }
        for(int i : l){
            System.out.print(i + " ");
        }
    }
}
