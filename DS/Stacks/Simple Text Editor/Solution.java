import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        int Q = s.nextInt();
        String currentString = "";
        Stack<String> StringStack =new Stack<String>();
        StringStack.push(currentString);
        StringBuilder printfinal = new StringBuilder();
        while(Q-- > 0) {
            int query = s.nextInt();
            switch(query) {
                case 1:
                    currentString = currentString + s.next();
                    StringStack.push(currentString);
                    break;
                case 2:
                    currentString = currentString.substring(0,currentString.length()-s.nextInt());
                    StringStack.push(currentString);
                    break;
                case 3:
                    printfinal.append(currentString.charAt(s.nextInt()-1) + "\n");
                    break;
                case 4:
                    StringStack.pop();
                    currentString=StringStack.peek();
            } 
        }
        System.out.println(printfinal.toString());
    }
}
