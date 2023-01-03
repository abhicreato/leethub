class Solution {
    public int findPeakElement(int[] nums) {
        
        int l = nums.length;

        int s = 1;
        int e = l - 2;
        
        if (l == 1) return 0;
        
        
        while(s<=e){
            
            int mid = (s+e) /2;
            
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid] < nums[mid + 1]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
            
        }
        
        if (nums[0] > nums[1]) return 0;
        
        return l - 1;
        
    }
}