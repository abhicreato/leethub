class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
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
        
        for(int i = 0 ;i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        
        return false;
        
    }
}