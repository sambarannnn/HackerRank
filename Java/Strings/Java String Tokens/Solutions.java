import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        s = s.trim();
        //Complete the code
        if(s.length()==0 || s.length()>400000){
            System.out.println(0);
            return;
        }
        String words[]=s.split("[ !,?.\\_'@]+");
        System.out.println(words.length);
        for(String word:words){
            System.out.println(word);
        }
}
}
