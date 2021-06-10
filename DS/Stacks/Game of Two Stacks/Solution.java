import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
        Collections.reverse(a);
        Collections.reverse(b);
        Stack<Integer> s1 = new Stack<Integer>();
        s1.addAll(a);
        Stack<Integer> s2 = new Stack<Integer>();
        s2.addAll(b);
        
        int maxsteps = 0;
        int asteps = 0;
        int bsteps = 0;
        int sum = 0;
        Stack<Integer> s1ele = new Stack<Integer>();
        //select suitable elements from stack a and store selected elements in s1ele
        while(!s1.empty() && sum + s1.peek() <= maxSum) {
            int x = s1.pop();
            sum += x;
            s1ele.push(x);
            asteps++;
        }
        maxsteps = asteps;
        //traverse s2 and add elements to sum, if sum becomes greater than maxsum then subtract last added element from s1 from the s1ele's top element
        while(!s2.empty() && asteps >= 0) {
            sum += s2.pop();
            bsteps++;
            while(sum > maxSum && asteps > 0) {
                sum -= s1ele.pop();
                asteps--;
            }
            if(maxsteps < asteps+bsteps && sum <= maxSum) {
                maxsteps = asteps + bsteps;
            }
        }    
        return maxsteps;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int maxSum = Integer.parseInt(firstMultipleInput[2]);

            String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aTemp[i]);
                a.add(aItem);
            }

            String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int bItem = Integer.parseInt(bTemp[i]);
                b.add(bItem);
            }

            int result = Result.twoStacks(maxSum, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

