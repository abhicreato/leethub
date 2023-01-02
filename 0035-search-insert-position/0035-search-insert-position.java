class Solution {
    public int searchInsert(int[] nums, int target) {
        
        if(target <= nums[0]) return 0;
        
        int l = nums.length;
        int s = 0;
        int e = l - 1;
        int mid = 0;
        
        while(s<=e){
            
            mid = (s+e)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <= target){
                s = mid + 1;
            }else{
                e = mid - 1;
            } 
            
        }
        
        return s;
        
    }
}