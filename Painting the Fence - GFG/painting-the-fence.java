//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    double mod = 1e9 + 7;
    double dp[];
    long countWays(int n,int k)
    {
        //code here.
        if(n == 0) return 0;
        
        if(n == 1) return k;
        
        dp = new double[n+1];
        
        // Memoazation
        // for(int i=0;i<=n;i++) dp[i] = -1;
        // return (long) solve(n,k);
        
        // tabulation

        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + (k * (k - 1));
        
        double twoSameColor = 0;
        double twoDiffColor = 0;
        
        for(int i=3;i<=n;i++){
            twoSameColor = dp[i - 2] * (k - 1);
            twoDiffColor = dp[i - 1] * (k - 1);
            dp[i] = (twoSameColor + twoDiffColor) % mod;
        }
        
        return (long) dp[n];
        
    }
    
    double solve(int n, int k){
        
        if(n == 0) return 0;
        
        if(n == 1) return k;
        
        if(dp[n] !=-1) return dp[n];
        
        double twoSameColor = 0;
        double twoDiffColor = 0;
        
        if(n == 2){
            twoSameColor = k;
            twoDiffColor = k * (k - 1);
            return twoSameColor + twoDiffColor;
        } 

        twoSameColor = solve(n - 2, k) * (k - 1);
        twoDiffColor = solve(n - 1, k) * (k - 1);
        
        return dp[n] = (twoSameColor + twoDiffColor) % mod;
        
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends