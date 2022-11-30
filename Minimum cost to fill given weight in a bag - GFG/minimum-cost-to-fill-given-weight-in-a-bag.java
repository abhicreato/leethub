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
	
	public int solve(int cost[], int N, int W){
	    
	    if(W == 0) return 0;
	    
	    if(N == 0) return 100000;
	    
	    if(dp[N][W] != -1) return dp[N][W];
	    
	    if(N <= W && cost[N - 1] != -1){
	        int take = cost[N - 1] + solve(cost, N , W - N);
	        int notTake = solve(cost, N - 1, W);
	        return dp[N][W] = Math.min(take, notTake);
	    }else{
	        return dp[N][W] = solve(cost, N - 1, W);
	    }
	    
	}
}