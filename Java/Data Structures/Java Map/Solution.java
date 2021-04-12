//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        HashMap<String, Integer> phonebook = new HashMap<String, Integer>();
        while(n-->0){
            phonebook.put(input.nextLine(), input.nextInt());
            input.nextLine();
        }

        while(input.hasNext()){
            String key = input.nextLine();
            if(phonebook.containsKey(key)){
                System.out.println(key + "=" + phonebook.get(key));
            }
            else{
                System.out.println("Not found");
            }
        }
    }
}
