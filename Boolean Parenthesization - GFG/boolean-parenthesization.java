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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int countWays(int N, String S){
        // code here
        Map<String,Integer> map = new HashMap<>();
        return solve(S, 0, N - 1, true, map);
    }
    
    static int solve(String s, int i, int j, boolean isTrue, Map<String,Integer> map){
        
        if(i>j) return 0;
        
        if(i == j){
            if(isTrue){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        String bol = isTrue ? "T" : "F";
        String key = i + " " +  j + " " + bol;
        
        if(map.containsKey(key)) return map.get(key);
        
        int ans = 0;
        
        for(int k = i + 1; k < j; k+=2){
            
            int lTrue = solve(s, i, k - 1, true, map);
            int lFalse = solve(s, i, k - 1, false, map);
            int rTrue = solve(s, k + 1, j, true, map);
            int rFalse = solve(s, k + 1, j, false, map);
            
            if(s.charAt(k) == '&'){
                
                if(isTrue){
                    ans = ans + (lTrue * rTrue);
                }else{
                    ans = ans + (lTrue * rFalse) + (lFalse * rTrue) + (lFalse * rFalse);
                } 
                
                
            }else if(s.charAt(k) == '|'){
                
                if(isTrue){
                     ans = ans + (lFalse * rTrue) + (lTrue * rFalse) + (lTrue * rTrue) ;
                }else{
                     ans = ans + (lFalse * rFalse);
                }
                
                
            }else if(s.charAt(k) == '^'){
                
                if(isTrue){
                    ans = ans + (lFalse * rTrue) + (lTrue * rFalse);
                }else{
                    ans = ans + (lFalse * rFalse) + (lTrue * rTrue);
                }
                
            }
            
        }
        
        map.put(key, ans%1003);
        
        return ans%1003;
        
    }
} 