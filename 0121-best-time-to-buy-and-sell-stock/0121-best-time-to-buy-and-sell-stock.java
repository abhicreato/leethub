class Solution {
    public int maxProfit(int[] prices) {

        int l = prices.length;
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i =0;i<l;i++){
            
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
            
        }
        
        return maxProfit;
        
        
    }
}