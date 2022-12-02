//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int h = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.countBT(h));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long dp[];
    
    static long countBT(int h){
      
      dp = new long[h + 1];
      
      Arrays.fill(dp,-1);
      
      return solve(h);
        
    }
    
    static long solve(int h){
         // code here
        if( h == 0 || h == 1 ) return 1;
        
        if(dp[h] != -1) return dp[h];
        
        long ans = (solve(h-1) * solve(h-2) + 
                    solve(h-2) * solve(h-1) +
                    solve(h-1) * solve(h-1));
        
        return dp[h] = ans % (long) (1e9 + 7);
    }
}


// A B C 

// ab + ba + cc

// 2ab + cc