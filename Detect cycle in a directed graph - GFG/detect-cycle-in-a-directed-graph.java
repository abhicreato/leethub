//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    boolean vis[];
    boolean dfsvis[];
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        vis = new boolean[V];
        dfsvis = new boolean[V];
        
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(solve(i,adj)) return true;
            }
        }
        
        return false;
        
    }
    
    public boolean solve(int node, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = true;
        dfsvis[node] = true;
        
        for(Integer curr: adj.get(node)){
            if(!vis[curr]){
                if(solve(curr,adj)) return true;
            }else if(vis[curr] && dfsvis[curr]){
                return true;
            }
        }
        
        dfsvis[node] = false;
        return false;
        
    }
}