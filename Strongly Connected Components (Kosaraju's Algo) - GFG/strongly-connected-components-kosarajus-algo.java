//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        int numOfSCC = 0;
        
        for(int i =0;i<V; i++){
            if(!visited[i])
            dfs(i,adj,s,visited);
        }
        
        Arrays.fill(visited,false);

        ArrayList<ArrayList<Integer>> rev = reverseGraphEdge(adj,V);
        
        while(!s.isEmpty()){
 
            int curr = s.pop();

            if(!visited[curr]) 
            {
                numOfSCC = numOfSCC + 1;
            
                dfsR(curr,rev,visited);
            }            
        }
        
        return numOfSCC;
    }
    
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean[] visited){
        
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
            if(!visited[nbr])
            dfs(nbr,adj,s,visited);
        }
        
        s.push(curr);
        
    }
    
     public void dfsR(int curr, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
           if(!visited[nbr])
            dfsR(nbr,adj,visited);
        }
        
    }
    
    
    public ArrayList<ArrayList<Integer>> reverseGraphEdge (ArrayList<ArrayList<Integer>> adj, int V){
        
        // ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        
        // for(int i=0; i<V; i++){
            
        //     reverseAdj.add(new ArrayList<Integer>());
          
        // }
        
        // for(int i=0; i<V; i++){
        //     for(Integer nbr: adj.get(i)){
        //         reverseAdj.get(nbr).add(i);
        //     }
        // }
        
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>(V);
        for(int i=0;i<V;i++)
        {
            reverseAdj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> original=adj.get(i);
            for(int neigh : original)
            {
                reverseAdj.get(neigh).add(i);
            }
        }
        
        return reverseAdj;
    
        
    }
}
