//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        int i =0;
        int j =0;
        ArrayList<Integer> ans = new ArrayList<>();
        //Queue<Integer> max = new LinkedList<>();
        Deque<Integer> max = new ArrayDeque<Integer>();
        
        while(j<n){
            
            while(max.size()> 0 && arr[j] > max.peekLast()){
                max.removeLast();
            }
            
            max.add(arr[j]);
            
            if(j - i + 1 == k){
                
                ans.add(max.peekFirst());
                
                if(max.peekFirst() == arr[i]){
                    max.removeFirst();
                }
                
                i++;
                
            }
            
            j++;
            
        }
        
        return ans;
    }
}

