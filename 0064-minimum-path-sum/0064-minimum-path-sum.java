class Solution {
    
    int dp[][];
    public int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        dp = new int [rows][cols];
        return solve(grid,0,0);
    }
    
    public int solve(int[][] grid, int i, int j){
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(i == rows - 1 && j == cols - 1) return grid[i][j];
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int right = Integer.MAX_VALUE - 1;
        int down = Integer.MAX_VALUE - 1;
        
        if(j + 1 < cols){
            right = solve(grid, i, j + 1);
        }
        
        if(i + 1 < rows){
            down = solve(grid, i + 1, j);
        }
        
        return dp[i][j] = grid[i][j] + Math.min(right, down);
        
    }
}