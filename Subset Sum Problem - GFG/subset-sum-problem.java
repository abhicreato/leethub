//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    static boolean sumS [][];

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        sumS = new boolean[N + 1][sum + 1];
        
        for(int i=0;i<N+1; i++){
            for(int j =0; j< sum + 1; j++){
                if(i == 0) sumS[i][j] = false;
                if(j == 0) sumS[i][j] = true;
            }
        }
        
        //solve(N,sum,arr);
        
        for(int i = 1 ; i < N + 1; i++){
            for(int j = 1 ; j < sum + 1; j++){
                if(arr[i - 1] <= j){
                    sumS[i][j] = sumS[i - 1][j - arr[i - 1]] || sumS[i - 1][j] ;
                }else{
                    sumS[i][j] = sumS[i - 1][j];
                }
            }
        }
        
        return sumS[N][sum];
        
    }
    
    static boolean solve(int i, int sum, int [] arr){
        
        if(i - 1 < 0 || sum < 0) return false;
        
        if(sum == 0) return true;
        
        if(sumS[i][sum]) return sumS[i][sum] || false;
        
        if(sum >= arr[i - 1]){
            return sumS[i][sum] = solve(i - 1, sum - arr[i - 1], arr) || solve(i - 1, sum, arr);
        }else{
            return sumS[i][sum] = solve(i - 1, sum, arr);
        }
        
    }
    

}