//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    double [] dp;
    double mod = 1e9 + 7;
    public long countFriendsPairings(int n) 
    { 
      //code here
      if(n == 0 || n == 1 || n == 2) return n;
      
      dp = new double[n+1];
      
      for(int i=0;i<=n;i++) dp[i] = -1;
      
      dp[0] = 0;
      dp[1] = 1;
      dp[2] = 2;
      
      for(int i = 3 ; i <= n ; i++){
          dp[i] = (dp[i-1] + ((i-1) * dp[i-2])) % mod;
      }
      
      return (long) dp[n];
      
      //return (long) solve(n);
    }
    
    public double solve(int n){
        
        if(n == 0 || n == 1 || n == 2) return n;
        
        if(dp[n] != -1) return dp[n];
        
        double ifSingle = solve(n - 1);
        double ifPaired = (n - 1) * solve(n - 2);
        
        return dp[n] = (ifSingle + ifPaired) % mod;
    }
}    
 