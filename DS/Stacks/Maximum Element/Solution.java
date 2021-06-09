import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Stack <Integer> st = new Stack<Integer>();
        Stack <Integer> max = new Stack<Integer>();
        while(n-- > 0) {
            int query = s.nextInt();
            switch(query) {
                case 1 :
                    int x = s.nextInt();

                    st.push(x);
                    if(max.empty() || max.peek() < x) {
                        max.push(x);
                    } else {
                        max.push(max.peek());
                    }
                    break;    
                case 2 :
                    st.pop();
                    max.pop();
                    break;     
                case 3 :
                    if(!max.empty())
                    System.out.println(max.peek());
                    break;
                default :
                    System.out.println("Invalid Query");
            }
        }
    }
}
