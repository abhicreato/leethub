class Solution {
    public int findMin(int[] nums) {
    
        int l = nums.length;
        int start = 0;
        int end = l - 1;
        
        while (start <= end) {
            if (nums[start] <= nums[end]) return nums[start];
            
            int mid = (start + end) / 2;
            
            if (nums[mid] >= nums[start]) start = mid + 1;
            else end = mid;
        }
        
        return nums[start];
    }
}