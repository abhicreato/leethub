class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        
        //Memoization
        dp = new int[nums.length + 1];
        for(int i=0;i<=nums.length;i++) dp[i] = -1;
        return solve(nums, 0) == 1 ? true : false ;
        
        // Greedy
        //int canReach = 0;
//         for (int i = 0; i <= canReach; i++) {
//             canReach = Math.max(canReach, i + nums[i]);
            
//             if (canReach >= nums.length - 1) return true;
//         }
        
//         return false;
  
    }
    
    public int solve(int[] nums, int currIndex){
        
        if(currIndex >= nums.length - 1) return 1;
        
        if(dp[currIndex] != -1) return dp[currIndex];
        
        int canReach = 0;
        
        for(int i = 1 ; i <= nums[currIndex] ; i++){
            canReach =  solve(nums, currIndex + i);
            
            if(canReach == 1) return dp[currIndex] = 1;
            
        }
        
        return dp[currIndex] = 0;
        
    }
}