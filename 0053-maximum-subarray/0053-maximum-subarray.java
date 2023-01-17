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

/*
**************** Logic ****************
DP:
Similar to 0-1 Knapsack.
1. We must pick the current element if the previous element was selected.
2. We may or may not pick the current element if the previous element was not selected.
Kadane's Algorithm:
If at any point sum becomes negative then no point keeping it because 0 is obviously greater than negative, so just make your sum 0.
*/