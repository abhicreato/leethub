//{ Driver Code Starts
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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    int ans;
    int steps;
    boolean visited [][];
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        ans = Integer.MAX_VALUE;
        steps = 0;
        
        // x and y cordinates which knight can go
        int [] dx = {2,2,-2,-2,1,-1,1,-1};
        int [] dy = {1,-1,1,-1,2,2,-2,-2};
        
        visited = new boolean[N + 1][N + 1];
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0],KnightPos[1]));
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                
                Pair curr = q.remove();
   
                if(curr.x > N  || curr.y > N  || curr.x < 1 || curr.y < 1 || visited[curr.x][curr.y]) continue;
                
                visited[curr.x][curr.y] = true;
                
                if(curr.x == TargetPos[0] && curr.y == TargetPos[1]){
                    //ans = Math.min(ans,steps);
                    
                    return steps;
                }
                
                // Move in all 8 direction to which knight can go
                for(int j=0 ; j<8; j++){
                    q.add(new Pair(curr.x + dx[j], curr.y + dy[j]));
                }
                
            }
            
            steps++;
            
        }
        
        return ans;
        
    }
    
    class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
}