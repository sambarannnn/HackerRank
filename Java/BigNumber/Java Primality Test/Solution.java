import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();

        scanner.close();
        int flag = 0;
        BigInteger check = new BigInteger(n);
        System.out.println(check.isProbablePrime(10) ? "prime" : "not prime");
    }
}
