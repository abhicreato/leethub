//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.isEularCircuitExist(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int ans = 0;
        boolean[] visited = new boolean[V];
        int withEdge =0;
        boolean allZeroDegree = true;
        
        for(int i=0; i<V; i++){
            if(adj.get(i).size() > 0){
                allZeroDegree = false;
                withEdge = i;
                break;
            }
        }
        
        if(!allZeroDegree){
            
            dfs(withEdge,adj,visited);
            
            for(int i=0;i<V;i++){
                
                if(visited[i] == false && adj.get(i).size() > 0){
                    return 0;
                }
            }
            
            int oddDegree = 0;
            
            for(int i=0;i<V;i++){
                if(adj.get(i).size() % 2 != 0)
                oddDegree++;
            }
            
            //System.out.println(oddDegree);
            
            if(oddDegree == 0){
                return 2;
            }else if(oddDegree == 2){
                return 1;
            }else if(oddDegree > 2){
                return 0;
            }
            
        }
        
        return 2;
    
    }
    
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
            if(!visited[nbr])
            dfs(nbr,adj,visited);
        }
    }
}