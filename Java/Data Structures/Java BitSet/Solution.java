import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        while(m-->0){
            String query = s.next();
            int lo = s.nextInt();
            int ro = s.nextInt();
            switch(query){
                case "AND" :
                    if(lo==1){
                        b1.and(b2);
                    }
                    else{
                        b2.and(b1);
                    }
                    break;
                case "OR" :
                    if(lo==1){
                        b1.or(b2);
                    }
                    else{
                        b2.or(b1);
                    }
                    break;
                case "XOR" :
                    if(lo==1){
                        b1.xor(b2);
                    }
                    else{
                        b2.xor(b1);
                    }
                    break;
                case "FLIP" :
                    if(lo==1){
                        b1.flip(ro);
                    }
                    else{
                        b2.flip(ro);
                    }
                    break;
                case "SET" :
                    if(lo==1){
                        b1.set(ro);
                    }
                    else{
                        b2.set(ro);
                    }
                    break;
                default :
                    break;
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());

        }
        s.close();

    }
}
