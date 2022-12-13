class Pair implements Comparable<Pair>{
    int x;
    int y;
    
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public int compareTo(Pair p){
        if(this.x!=p.x){
            return this.x-p.x;
        }else{
            return this.y-p.y;
        }
    }

}
class Solution {
    public int[][] merge(int[][] intr) {

        int row = intr.length;
        
        Pair in[] = new Pair[row];
        
        for(int i=0;i<row;i++){
            in[i] = new Pair(intr[i][0],intr[i][1]);
        }
        
        Arrays.sort(in);
        Stack<Pair> s = new Stack<>();
        Pair tempPair = null;
        
        for(int i=0;i<row;i++){
            if(s.empty()){
                s.push(in[i]);
            }else{
                tempPair = s.peek();
                if(in[i].x <= tempPair.y){
                    s.pop();
                    s.push(new Pair(tempPair.x, Math.max(tempPair.y,in[i].y)));
                }else{
                    s.push(in[i]);
                }
            }
        }
        
        int [][] op2 = new int[s.size()][2];
        
        int size=s.size();
        
        for(int i=0;i<size;i++){
            Pair t = s.pop();
            op2[i][0] = t.x;
            op2[i][1] = t.y;
        }

        return op2;
            
    }
}