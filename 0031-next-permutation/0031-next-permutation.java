class Solution {
    public void nextPermutation(int[] nums) {
        
        boolean pivotFound = false;
        int pivot = 0;
        int n = nums.length;
        
        // Identify pivot
        // Pivot is the element just before the non-increasing (weakly decreasing) suffix
        for(int i = n - 1; i > 0; i--){
            
            if(nums[i] > nums[i-1]){
                pivotFound = true;
                pivot = i - 1;
                break;
            }
            
        }
        
        // Entire array is in decreasing order, return sorted array
        if(!pivotFound){
            Arrays.sort(nums);
            return;
        }
        
        // Find rightmost successor of pivot in suffix
        int min = Integer.MAX_VALUE;
        int rsusor = 0;
        for(int i = pivot + 1;i<n;i++){
            if(nums[i] > nums[pivot] && nums[i] <= min){
                min = nums[i];
                rsusor = i;
            }
        }
        
        // Swap the pivot
        int temp = nums[rsusor];
        nums[rsusor] = nums[pivot];
        nums[pivot] = temp;
        
        // Reverse the suffix
        int i = pivot + 1;
        int j = n - 1;
        while (i < j) {
            //swap(nums[i], nums[j]);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        
    }
}