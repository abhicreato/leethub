//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int ans = 0;
        int parents[] = new int[V];
        Arrays.fill(parents, -1);
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        for(int i=0;i<adj.size();i++){
            for(ArrayList<Integer> nbr : adj.get(i)){
                q.add(new Pair(i , nbr.get(0), nbr.get(1)));
            }
        }

        while(!q.isEmpty()){
            
            Pair currEdge = q.remove();
            
            int srcAbsParent = getAbsParent(currEdge.src,parents);
            int dstAbsParent = getAbsParent(currEdge.dst,parents);
            
            if(srcAbsParent != dstAbsParent){
                ans = ans + currEdge.cost;
                union(currEdge,parents);
            }
            
        }
        
        return ans;
        
    }
    
    static int getAbsParent(int node, int [] parents){
        // Get Absolute parent of the node based on Union Find Set logic
        if(parents[node] < 0) return node;
        
        // colapsing logic to reduce recursing for subsequent query requests  
        // return parents[node] = getAbsParent(parents[node],parents);
        
        // Non colapsing logic
        return getAbsParent(parents[node],parents);
       
    }
    
    static void union(Pair node, int [] parents){
        // Merge two Sets based on, Union find logic 
        // Without ranking logic ie 
        // Connect src Absolute parent to destinations Absolute parent 
        // OR destination Absolute parent to src Absolute parent 
        int srcAbsParent = getAbsParent(node.src,parents);
        int dstAbsParent = getAbsParent(node.dst,parents);
        
        //parents[srcAbsParent] = dstAbsParent;
        parents[dstAbsParent] = srcAbsParent;
        
    }
    
}

class Pair implements Comparable<Pair>{
    
    int src;
    int dst;
    int cost;
    
    Pair(int src, int dst, int cost){
        this.src = src;
        this.dst = dst;
        this.cost =cost;
    }
    
    public int compareTo(Pair p){
        return this.cost - p.cost;
    }
    
    public String toString(){
        return "[SRC : " + this.src + " DEST : " + this.dst + " COST : " + this.cost + "]";
    }
    
}
