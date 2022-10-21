//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        Set<Integer> visited = new HashSet<>();
        
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(ArrayList<Integer> edge:Edges){
            int src=edge.get(0);
            int des=edge.get(1);
            
            ArrayList<Integer> list = map.getOrDefault(src, new ArrayList<Integer>());
            list.add(des);
            map.put(src,list);
            
            ArrayList<Integer> list2 = map.getOrDefault(des, new ArrayList<Integer>());
            list2.add(src);
            map.put(des,list2);
        }
        
        for(int i=1;i<=N;i++){
            if(solve(i, N, visited, map)) return true;
        }
       
        return false;
    }
    
    public boolean solve(int curr, int vertex, Set<Integer> visited, Map<Integer,ArrayList<Integer>> edges){
        
        visited.add(curr);
        
        if(visited.size() == vertex) return true;

        for(int nbr: edges.get(curr)){
            if(!visited.contains(nbr)){
              if(solve(nbr, vertex, visited, edges)) return true;
            }
        
        }
        
        visited.remove(curr);
        
        return false;
        
    }
} 