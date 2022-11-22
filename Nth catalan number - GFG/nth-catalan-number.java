//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        
        BigInteger ANS[] = new BigInteger[n+1];
        ANS[0] = BigInteger.ONE;
        ANS[1] = BigInteger.ONE;
        
        if(n == 0 || n== 1) return BigInteger.ONE;
        
        for(int i=2;i<n+1;i++){
            int x = i - 1;
            int y = 0;
            BigInteger temp = BigInteger.ZERO;
            while(x > -1 && y < i){
               temp = temp.add(ANS[y].multiply(ANS[x]));
               x--;
               y++;
            }
            //System.out.println(temp);
            ANS[i] = temp;
        }
        
        return ANS[n];
        
    }
}