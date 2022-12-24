class Solution {
    public int findMin(int[] nums) {
        
        int l = nums.length;
        int start = 0;
        int end = l - 1;
        
        while(start <= end){
            
            int mid = (start + end)/2;
            
            int pre = (mid + l - 1) % l;
            int next = (mid + 1) % l;
            
            if(nums[pre] >= nums[mid] && nums[next] >= nums[mid]){
                return nums[mid];
            }
            if(nums[start] <= nums[end]){
                return nums[start];
            }
            if(nums[mid] >= nums[start]){
                start = mid + 1;
            }
            if(nums[mid] <= nums[end]){
                end = mid - 1;
            }
            
        }
        
        return 0;
    }
}