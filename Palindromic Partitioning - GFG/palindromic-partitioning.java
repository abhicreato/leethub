//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][];
    
    static int palindromicPartition(String str)
    {
        // code here
        int sl = str.length();
        
        dp = new int [sl+1][sl+1];
        
        return solve(str, 0, sl - 1);
    }
    
    static int solve(String s, int i, int j){
        
        if(i >= j || isPali(s, i, j)) return 0;
        
        if(dp[i][j] !=0) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k<=j-1; k++){
            
            int temp = solve(s, i, k) + solve(s, k + 1, j) + 1;
            
            min = Math.min(min, temp);
        }
        
        return dp[i][j] = min;
        
    }
    
    static boolean isPali(String s, int i, int j){

        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}