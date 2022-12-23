class Solution {
    public int findMin(int[] nums) {
        
        int l = nums.length;
        int start = 0;
        int end = l - 1;
        int mid = 0;
        int ans = -1;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            int pre = (mid + l - 1) % l;
            int next = (mid + 1) % l;
            
            if(nums[pre] >= nums[mid] && nums[next] >= nums[mid]){
                return nums[mid];
            }else if(nums[start] <= nums[end]){
                return nums[start];
            }else if(nums[mid] >= nums[start]){
                start = mid + 1;
            }else if(nums[mid] <= nums[end]){
                end = mid - 1;
            }
            
        }
        
        return ans;
    }
}