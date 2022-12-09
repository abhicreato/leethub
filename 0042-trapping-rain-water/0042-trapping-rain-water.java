class Solution {
    public int trap(int[] height) {
        
        int l = height.length;
        int maxAtRight[] = new int[l];
        int maxAtLeft[] = new int[l];
        int ans =0;
        
        maxAtLeft[0] = height[0];
        for(int i=1;i<l;i++){
          maxAtLeft[i] = Math.max(maxAtLeft[i-1],height[i]);
        }
        
        maxAtRight[l-1] = height[l-1];
        for(int i=l-2;i>=0;i--){
            
            maxAtRight[i] = Math.max(maxAtRight[i+1],height[i]);

        }

        for(int i=0;i<l;i++){
            
            int min = Math.min(maxAtRight[i],maxAtLeft[i]);
            
            ans = ans + (min - height[i]);
            
        }
        
        
        return ans;
        
    }
}