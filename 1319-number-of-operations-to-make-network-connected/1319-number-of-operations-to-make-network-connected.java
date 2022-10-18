class Solution {
    
    int edge;
    int vertices;
    Map<Integer,ArrayList<Integer>> adjMap;
    int numOfComp;
    
    public int makeConnected(int n, int[][] connections) {
        
        edge = connections.length;
        vertices = n;
        adjMap = generateAdjL(connections);
        
        // DFS to find # of components
        boolean visited[] = new boolean[vertices];
        for(int i = 0; i<vertices; i++){
            if(!visited[i]){
                dfs(i,visited,adjMap);
                numOfComp++;
            }
        }
        
        // Min edge required to connect components 
        
        int redundentEdge = edge - ((vertices - 1) - (numOfComp - 1));
        
        if(redundentEdge >= (numOfComp - 1)) return numOfComp - 1;
        
        return -1;
 
    }
    
    public void dfs(int val, boolean[] visited, Map<Integer,ArrayList<Integer>> adjMap){
        
        if(visited[val]) return;
        
        visited[val] = true;
        
        for(Integer key: adjMap.getOrDefault(val, new ArrayList<Integer>())){
            dfs(key,visited,adjMap);
        }      
    }
    
    public Map<Integer,ArrayList<Integer>> generateAdjL( int[][] connections){
        
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
        for(int r = 0 ; r < connections.length; r++){
            
            if(adj.containsKey(connections[r][0])){
                adj.get(connections[r][0]).add(connections[r][1]);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(connections[r][1]);
                adj.put(connections[r][0],list);
            }
            
             if(adj.containsKey(connections[r][1])){
                adj.get(connections[r][1]).add(connections[r][0]);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(connections[r][0]);
                adj.put(connections[r][1],list);
            }
        }
        
        return adj;
        
    }
}