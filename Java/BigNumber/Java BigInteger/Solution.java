import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner input = new Scanner(System.in);
        BigInteger a = new BigInteger(input.next());
        BigInteger b = new BigInteger(input.next());
        BigInteger c = a.add(b);
        BigInteger d = a.multiply(b);
        System.out.println(c + "\n" + d);
    }
}
