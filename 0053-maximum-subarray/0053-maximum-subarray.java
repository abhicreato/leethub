class Solution {
    public int maxSubArray(int[] nums) {
        
        //return solve(nums, 0,0);
        
        // Kadane's Algorithm
        int max_so_far = 0;
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            max_so_far += nums[i];
            
            ans = Math.max(ans, max_so_far);
            
            max_so_far = Math.max(max_so_far, 0);
        }
        
        return ans;
        
    }
    
    public int solve(int[] num, int currIndex, int sum){
        
        
        return 0;
    }
}