//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        Map<Character,Integer> map = new LinkedHashMap();
        char ans = '$';
        
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
                ans = c;
            }else{
                map.put(c, map.get(c)+1);
                ans = '$';
            }
        }
        
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            
            if(e.getValue() == 1){
                return e.getKey();
            }
        }
        
        return ans;
        
        
    }
}

