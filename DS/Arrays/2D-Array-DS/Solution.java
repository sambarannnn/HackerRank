import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        
        int[][] array = new int[arr.size()][]; 
        for (int i = 0; i < array.length; i++) { 
            array[i] = new int[arr.get(i).size()]; 
        } 
        for(int i=0; i<arr.size(); i++){ 
            for (int j = 0; j < arr.get(i).size(); j++) { 
                array[i][j] = arr.get(i).get(j); 
            } 
        }
        int[] sum = new int[16];
        int k = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
sum[k++]=array[i][j]+array[i][j+1]+array[i][j+2]+array[i+1][j+1]+array[i+2][j]+array[i+2][j+1]+array[i+2][j+2];
            }
        }

        for(int i = 0; i < 16; i++){
            for(int j = 0; j <= i ; j++){
                if(sum[i]<sum[j]){
                    int temp = sum[i];
                    sum[i] = sum[j];
                    sum[j] = temp;
                }
            }
        }
        return sum[15];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
