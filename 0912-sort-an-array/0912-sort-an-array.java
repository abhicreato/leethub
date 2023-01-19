class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }
    
    public int[] sort(int[] nums, int s, int e){
        
        if(s == e){
            int[] arr = new int[1];
            arr[0] = nums[s];
            return arr;
        }
        
        int mid = (s + e) / 2;
        
        int arr1[] = sort(nums, s, mid);
        int arr2[] = sort(nums, mid + 1, e);
        
        return mergeSortedArray(arr1, arr1.length, arr2, arr2.length);
        
    }
    
    public int[] mergeSortedArray(int[] arr1, int n, int[] arr2, int m){
        
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[m+n]; 
        
        while(i < n && j < m){
            
            if(arr1[i] < arr2[j]){
                merged[k++] = arr1[i];
                i++;
            }else{
                merged[k++] = arr2[j];
                j++;
            }  
        }
        
        while(i < n){
            merged[k++] = arr1[i];
            i++;
        }
        
        while(j < m){
            merged[k++] = arr2[j];
            j++;
        }
        
        return merged; 
        
    }
}