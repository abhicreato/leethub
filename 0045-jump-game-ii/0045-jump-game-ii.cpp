class Solution {
public:
    int helper(vector<int>& nums, int n, vector<int>& dp) {
        if (n >= nums.size() - 1) return 0;
        
        if (dp[n] != -1) return dp[n];
        
        int ans = INT_MAX - 1;
        for (int i = 1; i <= nums[n]; i++) {
            int temp = 1 + helper(nums, n + i, dp);
            ans = min(ans, temp);
        }
        
        return dp[n] = ans;
    }
    
    int jump(vector<int>& nums) {
        //Memoization
        vector<int> dp(nums.size(), -1);
        return helper(nums, 0, dp);
        
        // Greedy
//         int currEnd = 0, currFarthest = 0, steps = 0;
//         for (int i = 0; i < nums.size() - 1; i++) {
//             currFarthest = max(currFarthest, i + nums[i]);
            
//             if (i == currEnd) {
//                 steps++;
//                 currEnd = currFarthest;
//             }
//         }
        
//         return steps;
    }
};