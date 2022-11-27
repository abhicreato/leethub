class Solution {

public:
    int maxi = 0;
    int recursive(int i,int j, vector<vector<char>> &matrix, vector<vector<int>> &dp){
        if(i>=matrix.size() || j>=matrix[0].size()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = recursive(i,j+1,matrix,dp);
        int diagonal = recursive(i+1,j+1,matrix,dp);
        int down = recursive(i+1,j,matrix,dp);
        if(matrix[i][j]=='1'){
            int x = 1+min(right,min(diagonal,down));
            maxi = max(maxi,x);
            return dp[i][j]=x;
        } 
        return dp[i][j]=0;
    }
    
    int maximalSquare(vector<vector<char>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        recursive(0,0,matrix,dp);
        return maxi*maxi;
    }
};