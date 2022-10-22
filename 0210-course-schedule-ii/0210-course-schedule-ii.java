class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjn list
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i<prerequisites.length; i++){            
            ArrayList<Integer> list = graph.getOrDefault(prerequisites[i][0],new ArrayList<Integer>());
            list.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0],list);
        }

        // detect a cycle , if cycle exist then it is impossible to order course to take
        boolean visited[] = new boolean[numCourses];
        boolean visiDfs[] = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(detectCycle(i, graph, visited, visiDfs))return new int[0];
            }
        }
        
         // Sort Topological
        int[] ans= new int[numCourses];
        Arrays.fill(visited,false);
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0;i<numCourses;i++){
            if(!visited[i])
                topoSortGraph(i, graph , s, visited);
        }
        
        System.out.println(s);
        
        int size = s.size();
        for(int i=size-1;i>=0;i--){
            ans[i] = s.pop();
        }
        
        return ans;  
        
    }
    
    public void topoSortGraph(int curr, Map<Integer,ArrayList<Integer>> g, Stack<Integer> s, boolean[]visisted){
        
        if(visisted[curr]) return;
        
        visisted[curr] = true;
        
        if(g.get(curr) != null){
          for(int nbr: g.get(curr)){
                topoSortGraph(nbr, g, s, visisted);
            }  
        }
        
        s.push(curr);
    }
    
    public boolean detectCycle(int curr, Map<Integer,ArrayList<Integer>> g, boolean[] visisted, boolean[] visiDfs){
        
        visisted[curr] = true;
        
        visiDfs[curr] = true;
        
        if(g.get(curr) != null){
            for(Integer nbr: g.get(curr)){
                if(!visisted[nbr]){
                    if(detectCycle(nbr, g,visisted,visiDfs)) return true;
                }else if(visiDfs[nbr]){
                    return true;
                }
                    
            }
        }
        
        visiDfs[curr] = false;
        
        return false;
        
    }
}