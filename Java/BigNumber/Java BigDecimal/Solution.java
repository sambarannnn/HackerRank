import java.math.BigDecimal;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
            BigDecimal a = new BigDecimal(s[i]);
            BigDecimal b = new BigDecimal(s[j]);
            String t = new String("");
            if(a.compareTo(b)>0){//a<b
                t = s[i];
                s[i] = s[j];
                s[j] = t;
                }

            }
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
