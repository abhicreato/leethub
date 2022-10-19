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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int dist[];
    
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        dist = new int[n];
        
        //code here
        Arrays.fill(this.dist,9999);
        this.dist[0] = 0;

        // Relax graph for (num of vertex - 1 ) times
        for(int i = 0; i < n - 1; i++){
            if(!relaxGraph(edges, n)) return 0;
        }
        
        // relax one more time 
        //temp = relaxGraph(edges,n);
        
        // if still they are not equal it means it has negative cycle 
        if(relaxGraph(edges,n)) return 1;
        
        return 0;
        
    }
    
    public boolean relaxGraph(int[][] edges, int numOfVertex){
        
        boolean updated = false;
        
        for(int i = 0 ; i < edges.length ; i++){
            
            if( dist[edges[i][0]] + edges[i][2] < dist[edges[i][1]]){
                dist[edges[i][1]] = dist[edges[i][0]] + edges[i][2];
                updated = true;
            }
            // int nodeSrc = edges[j][0];
            // int nodeDest = edges[j][1];
            // int weight = edges[j][2];
            // cost[nodeDest]=Math.min(cost[nodeDest],cost[nodeSrc]+weight);
        } 
        
        return updated;
    }
    
    public boolean compareDist(int temp[]){
        return Arrays.equals(this.dist, temp);
    }
}