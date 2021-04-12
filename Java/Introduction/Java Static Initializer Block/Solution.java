import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static Scanner sc = new Scanner(System.in);
static int B = sc.nextInt();
static int H = sc.nextInt();
static boolean flag = true;
static{
    try{
        if(H <= 0 || B <= 0){
            flag = false;
            throw new Exception("Breadth and height must be positive");
        }
    }catch(Exception e){
        System.out.println(e);
    }
}
public static void main(String[] args){
