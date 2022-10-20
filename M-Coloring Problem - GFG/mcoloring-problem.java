//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color [] = new int[n];
        
        if(possibleToColor(0,color,m,n,graph)) return true;
        
        else return false;
    }
    
    boolean possibleToColor(int currNode, int[] color, int m, int N, boolean graph[][] ){
        
        if(currNode == N) return true;
        
        for(int i=1; i<=m; i++){
            if(canColor(currNode,color,graph,N,i)){
                color[currNode] = i;
                if(possibleToColor(currNode + 1, color ,m , N, graph)) return true;
                color[currNode] = 0;
            }
        }
        
        return false;
        
    }
    
    boolean canColor(int node, int[] colors, boolean graph[][], int N, int color){
        
        for(int i=0;i<N;i++){
            if(graph[node][i] && colors[i] == color){
                return false;
            }
        }
        return true;
    }
}