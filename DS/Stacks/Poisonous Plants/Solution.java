import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    static class Pair {
    int val, count;
    public Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }
}

// Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        Stack<Pair> stack = new Stack<>();
        int cnt = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            int temp = 0;
            while (!stack.empty() && p[i] < stack.peek().val) {
                temp++;
                Pair pair = stack.pop();
                temp = Math.max(temp, pair.count);
            }
            cnt = Math.max(cnt, temp);
            stack.push(new Pair(p[i], temp));
        }
        return cnt;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p[i] = pItem;
        }

        int result = Result.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
