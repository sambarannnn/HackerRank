import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest  = s.substring(0, k);

        for (int i = 0; i <= s.length() - k; i++) {
            String check = s.substring(i, i + k);
            if (check.compareTo(smallest) < 0){//negative value means check is smaller
                smallest = check;
            }
            if (check.compareTo(largest) > 0) {
                largest = check;
            }
        }

        return smallest + "\n" + largest;
    }
