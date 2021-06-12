import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static Stack<Integer> insert = new Stack<Integer>();
    static Stack<Integer> deletion = new Stack<Integer>();
    //static Stack<Integer> auxilliary = new Stack<>();
    
    static void enqueue(int x) {
        insert.push(x);
    }
    
    static void dequeue() {
        if(deletion.empty() && !insert.empty()) {
            while(!insert.empty()) {
                deletion.push(insert.pop());
            } 
        } else if(deletion.empty() && insert.empty()) {
            System.out.println("Queue is empty!");
        }
        deletion.pop();
    }
    
    static void printfront() {
        if(deletion.empty() && !insert.empty()) {
            while(!insert.empty()) {
                deletion.push(insert.pop());
            } 
        } else if(deletion.empty() && insert.empty()) {
            System.out.println("Queue is empty!");
        }
        System.out.println(deletion.peek());
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        int query;
        while(Q-- > 0) {
            query = s.nextInt();
            switch(query) {
                case 1 :
                    int x = s.nextInt();
                    enqueue(x);
                    break;
                case 2 :
                    dequeue();
                    break;
                case 3 :
                    printfront();
                    break;
            }
        }
    }
}
