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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int sumOfArray = 0;
	    
	    for(int i=0;i<n;i++){
	        sumOfArray += arr[i];
	    }
	    
	    //System.out.println("Total sum : " + sumOfArray);
	    
	    int tar = sumOfArray / 2;
	    
	    //System.out.println("Total sum half: " + tar);
	    
	    boolean dp[][] = new boolean[n+1][tar+1];
	    
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<tar+1;j++){
	            if(i==0) dp[i][j]=false;
	            if(j==0) dp[i][j]=true;
	        }
	    }
	    
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<tar+1;j++){
	            
	            if(j >= arr[i - 1]){
	                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
	            }else{
	                dp[i][j] = dp[i - 1][j];
	            }
	            
	        }
	    }
	    
	    int fSubsetSum = -1;
	    
	    for(int i = tar ; i >= 0 ; i--){
	        if(dp[n][i]){
	            fSubsetSum = i;
	            break;
	        } 
	    }
	    
	    //System.out.println("1st subset sum : " + fSubsetSum);

	    int sSubsetSum = sumOfArray - fSubsetSum;
	    
	    //System.out.println("2nd subset sum : " + sSubsetSum);
	    
	    return Math.abs(fSubsetSum - sSubsetSum);
	    
	   // System.out.println("Min Diffrence : " + diff);
	    
    //     return diff;
	} 
	
}
