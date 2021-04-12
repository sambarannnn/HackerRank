import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        try{
            int x = s.nextInt();
            int y = s.nextInt();
            System.out.println(x/y);
        }catch(InputMismatchException e1){
            System.out.println(e1.getClass().getName());
        }
        catch(ArithmeticException e2){
            System.out.println(e2.getClass().getName()+": "+e2.getMessage());
        }
    }
}
