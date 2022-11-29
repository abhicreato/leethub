//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int K = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumPairWithDifferenceLessThanK(arr, N, K));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution { 
    
    static int[][] dp;
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        // Your code goes here 
        dp = new int[N][N];
        Arrays.sort(arr);
        return solve(arr, 1, 0, N, K);
    }
    
    public static int solve(int [] arr, int currIndex, int preValIndex, int N, int K){
        
        if(currIndex >= N) return 0;
        
        if(dp[currIndex][preValIndex] != 0) return dp[currIndex][preValIndex];
        
        if(arr[currIndex] - arr[preValIndex] < K){
            
            int take = arr[currIndex] + arr[preValIndex] + solve(arr, currIndex + 2, preValIndex + 2, N, K);
            int notTake = solve(arr, currIndex + 1, preValIndex + 1, N, K);
            
            return dp[currIndex][preValIndex] = Math.max(take,notTake);
            
        }else{
            return dp[currIndex][preValIndex] = solve(arr, currIndex + 1, preValIndex + 1, N, K);
        }
        
        
    }
    
}
