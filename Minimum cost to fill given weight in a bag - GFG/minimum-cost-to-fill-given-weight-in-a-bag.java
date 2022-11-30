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
                    int w = sc.nextInt();
                    int cost[] = new int[n];
                    for(int i = 0;i<n;i++)
                        cost[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minimumCost(cost,n,w));
                }
        }
}    
// } Driver Code Ends


class Solution
{
    int dp[][];
	public int minimumCost(int cost[], int N, int W)
	{
		// Your code goes here
	   dp = new int [N+1][W+1];
	   for(int [] i : dp){
	       Arrays.fill(i, -1);
	   }
	   
	   int op = solve(cost, N, W);
	   
	   return  op < 0 ? -1 : op;
	}
	
	public int solve(int cost[], int n, int w){
	    
	    if(w == 0) return 0;
	    
	    if(n == 0) return 100000;
	    
	    if(dp[n][w] != -1) return dp[n][w];
	    
	   // if (n <= w && cost[n-1] != -1) {
	   //     return dp[n][w] = Math.min(cost[n-1] + solve(cost, n, w - n), solve(cost, n - 1, w));
	   // }
	    
	   // return dp[n][w] = solve(cost, n - 1, w);
	    
	    if(n <= w && cost[n - 1] != -1){
	        int take = cost[n - 1] + solve(cost, n , w - n);
	        int notTake = solve(cost, n - 1, w);
	        return dp[n][w] = Math.min(take, notTake);
	    }else{
	        return dp[n][w] = solve(cost, n - 1, w);
	    }
	    
	}
}