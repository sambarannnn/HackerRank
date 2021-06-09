import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> st = new Stack<Character>();
        char[] br = s.toCharArray();
        for(char c : br) {
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if(st.empty())
                    return "NO";
                //')'='('+1 &'['=']'+2 &'{'='}'+2
                else if(c == st.peek()+1 || c == st.peek()+2)
                    st.pop();
                else
                    return "NO";
            }
        }
        if(st.empty())
            return "YES";
        else
            return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
