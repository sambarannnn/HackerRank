import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        int count1 = 0, count2 = 0, flag = 0;
        a = a.toLowerCase();
        b = b.toLowerCase();
        if(a.length()!=b.length()) return false;

        int chars[] = new int[26];
        for(int i = 0; i < 26; i++){
            chars[i] = 0;
        }

        for(int i = 0; i < a.length(); i++){
            int j = 0;
            while(j!=(int)a.charAt(i)-97){
            j++;
            }
            chars[j]++;
        }
        for(int i = 0; i < b.length(); i++){
            int k = 0;
            while(k!=(int)b.charAt(i)-97){
            k++;
            }
            chars[k]--;
        }
        for(int i = 0; i < 26; i++){
            if(chars[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
