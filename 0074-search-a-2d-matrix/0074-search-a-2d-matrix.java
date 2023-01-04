class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int s = 0;
        int e = r - 1;
        
        while(s<=e){
            
            int mid = (s+e)/2;
            
            if(target >= matrix[mid][0] && target <= matrix[mid][c-1]){
                return binarySeach(matrix[mid],target);
            }
            
            if(target < matrix[mid][0]) e = mid - 1;
            else s = mid + 1;
            
        }
        
        return false;
        
        
//         int i = 0;
//         int j = matrix[0].length-1;
        
//         while (i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
//             if(matrix[i][j] == target){
//                 return true;
//             }
//             else if(matrix[i][j] < target){
//                 i++;
//             }else if(matrix[i][j] > target){
//                 j--;
//             }
//         }
        
//         return false;
        
//         for(int i = 0 ;i<matrix.length;i++){
//             for(int j = 0; j<matrix[0].length;j++){
//                 if(matrix[i][j] == target){
//                     return true;
//                 }
//             }
//         }
        
       // return false;
        
    }
    
    
    public boolean binarySeach(int[] nums, int target){
        
        int l = nums.length;
        int s = 0;
        int e = l - 1;
        
        while(s<=e){
            
            int mid = (s+e)/2;
            
            if(nums[mid] == target){
                return true;
            }
            
            if(nums[mid] > target) e = mid - 1;
            else s = mid + 1;
            
        }
        
        return false;
        
    }
}