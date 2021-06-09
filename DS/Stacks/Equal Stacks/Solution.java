import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static int calc_sum(List<Integer> h) {
        int sum = 0;
        for(int i : h) {
            sum += i;
        }
        return sum;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        //create 3 stacks of the given lists
        Stack<Integer> st1 = new Stack<Integer>();
        Collections.reverse(h1);//reversing before inserting in stack since its gonna be inserted using lifo
        st1.addAll(h1);
        
        Stack<Integer> st2 = new Stack<Integer>();
        Collections.reverse(h2);
        st2.addAll(h2);
        
        Stack<Integer> st3 = new Stack<Integer>();
        Collections.reverse(h3);
        st3.addAll(h3);
        //keep removing top element of the tallest stack until it becomes equal to the shortest or shorter
        int min = 0;
        int sum1 = calc_sum(h1);
        int sum2 = calc_sum(h2);
        int sum3 = calc_sum(h3);
        
        while(!st1.empty() && !st2.empty() && !st3.empty()) {
            min = Math.min(sum1, Math.min(sum2, sum3));
            //for each stack, pop top element until its equal to or shorter than the shortest stack
            while(sum1 > min)
                sum1 -= st1.pop();
                
            while(sum2 > min)
                sum2 -= st2.pop();
                
            while(sum3 > min)
                sum3 -= st3.pop();
            
            if(sum1 == sum2 && sum2 == sum3)
                return sum1;
        }
        //if either stacks becomes empty during popping, min will be 0
        return 0;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
