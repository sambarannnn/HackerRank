import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    //function to generate prime nos
    static int next_prime(int current_prime){
        int prime = current_prime;
        boolean isPrime = false;
        while (!isPrime){
            prime++;
            isPrime = true;
            for (int i=2; i<prime; i++){
                if (prime % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        return prime;
    }

    static Stack<Integer> data;
    static Stack<Integer> B;
    static Stack<Integer> A;
    public static List<Integer> waiter(int[] number, int q) {
    // Write your code here
        data = new Stack<Integer>();
        B = new Stack<Integer>();
        A = new Stack<Integer>();
        for (int i = 0; i < number.length; i++)
            data.push(number[i]);
        List<Integer> result = new ArrayList<>();
        int iter_num = q;
        int curNum;
        int prime=2;
        while (iter_num-->0){
            A.clear();
            while (!data.isEmpty()){
                curNum = data.pop();
                if (curNum % prime == 0)
                    B.push(curNum);
                else
                    A.push(curNum);
            }
            prime = next_prime(prime);//to generate prime nos
            while (!B.isEmpty()){
                result.add(B.pop());
            }
            data = (Stack<Integer>) A.clone();
        }
        while (!A.isEmpty())
            result.add(A.pop());
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        String[] numberTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            int numberItem = Integer.parseInt(numberTemp[i]);
            number[i] = numberItem;
        }

        List<Integer> result = Result.waiter(number, q);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
