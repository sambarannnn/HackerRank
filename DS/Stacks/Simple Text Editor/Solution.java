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
        Stack<String> st =new Stack<String>();
        st.push(currentString);
        StringBuilder printfinal = new StringBuilder();
        while(Q-- > 0) {
            int query = s.nextInt();
            switch(query) {
                case 1:
                    currentString = currentString + s.next();
                    st.push(currentString);
                    break;
                case 2:
        currentString = currentString.substring(0,currentString.length()-s.nextInt());
                    st.push(currentString);
                    break;
                case 3:
                    printfinal.append(currentString.charAt(s.nextInt()-1) + "\n");
                    break;
                case 4:
                    st.pop();
                    currentString=st.peek();
            } 
        }
        System.out.println(printfinal.toString());
    }
}
