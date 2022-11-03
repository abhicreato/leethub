class Solution {
    
    int dp[][] ;
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int l1 = text1.length();
        int l2 = text2.length();
        
        dp = new int[l1 + 1][l2 + 1];
        
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(text1,l1,text2,l2);
        
    }
    
    public int solve(String t1,int l1, String t2, int l2){
        
        if(l1 == 0 || l2 == 0) return 0;
        
        if(dp[l1][l2] != -1) return dp[l1][l2];
        
        if(t1.charAt(l1 - 1) == t2.charAt(l2 - 1)){
            return dp[l1][l2] =  1 + solve(t1.substring(0, l1 - 1), l1 - 1, t2.substring(0, l2 - 1),l2-1);
        }else{
            return dp[l1][l2] = Math.max(solve(t1, l1, t2.substring(0, l2 - 1), l2 - 1), solve(t1.substring(0, l1 - 1),l1 - 1, t2, l2));
        }
    }
}