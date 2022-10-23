class Solution {
    
    int ans = -1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer,ArrayList<Flight>> fMap = new HashMap<>();

        for(int [] f : flights){
            
            ArrayList<Flight> list = fMap.getOrDefault(f[0],new ArrayList<Flight>());
            list.add(new Flight(0,f[1],f[2]));
            fMap.put(f[0],list);
            
        }
        
        int cost[] = new int[n];
        Arrays.fill(cost,999999);
        cost[src] = 0;
        LinkedList<Flight> q = new LinkedList<>();
        q.add(new Flight(0,src,0));
        
        while(!q.isEmpty()){
            
            System.out.println(q);
            
            Flight curr = q.remove();
            
            if(curr.stops > k) continue;
            
            if(fMap.get(curr.dst) != null){
                for(Flight c : fMap.get(curr.dst)){
                    
                    if(c.cost + curr.cost < cost[c.dst]  && curr.stops <= k){
                            cost[c.dst] = c.cost + curr.cost;
                            q.add(new Flight(curr.stops + 1, c.dst, c.cost + curr.cost));
                        }
                    }
                    
                }
            }
        
            if(cost[dst] < 999999) return cost[dst];  
        
            return -1;
        }
        
       class Flight {
         
        int stops;
        int dst;
        int cost;
        
        Flight(int stops,int dst,int cost){
            this.stops = stops;
            this.dst = dst;
            this.cost = cost;
        }
        

        
        public String toString(){
            return "[ " + "stops : " + this.stops + " dst : " + this.dst + ", Cost " + this.cost +" ]";
        }
        
    }     
}
    