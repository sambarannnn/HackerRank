public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    // Write your code here
        
        int[] arr1 = new int[a.size()];
        int[] arr2 = new int[b.size()];
        
        for(int i=0;i<a.size();i++){
            arr1[i]=a.get(i);
        }
        
        for(int i=0;i<b.size();i++){
            arr2[i]=b.get(i);
        }
        
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]= 1+dp[i-1][j-1];
                }else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i=n,j=m;
        while(i>0 && j>0){
            if(arr1[i-1]==arr2[j-1]){
                res.add(arr1[i-1]);
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    j--;
                }else i--;
            }
        }
        Collections.reverse(res);
        // for(int x : res){
        //     System.out.print(x +" ");
        // }
        return res;
    }
