class Solution {
    public int search(int[] nums, int target) {
    
        int l = nums.length;
        int start = 0;
        int end = l - 1;
        
        int minIdx = 0;
        
        while(start <= end){
            
            int mid = (start + end)/2;
            
            if(nums[minIdx] == target){
                return minIdx;
            }
            
            int pre = (mid + l - 1) % l;
            int next = (mid + 1) % l;
            
            if(nums[pre] >= nums[mid] && nums[next] >= nums[mid]){
                minIdx = mid;
                break;
            }
            if(nums[start] <= nums[end]){
                minIdx = start;
                break;
            }
            if(nums[mid] >= nums[start]){
                start = mid + 1;
            }
            if(nums[mid] <= nums[end]){
                end = mid - 1;
            }
            
        }
        
        
        int left = bs(nums, 0, minIdx - 1, target);
        int right = bs(nums, minIdx, l-1, target);
                
        if(left!=-1){
            return left;
        }if(right!=-1){
            return right;
        }
        return -1;

    }
    
    int bs(int arr[],int s,int e,int key){

        while(s<=e){
            
            int mid = (s+e)/2;
            
            if(arr[mid] == key){
                return mid;
            }
            
            if(arr[mid]>key) e = mid - 1;
            else s = mid + 1;
        }
        
        return - 1;
    }
    
  
}