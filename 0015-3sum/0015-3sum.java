class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        int l = nums.length;
        int strat,end;
        
        for(int i = 0 ;i<l; i++){
            
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            strat = i + 1; end = l - 1;
            
            while(strat<end){
                
                int sum = nums[i] + nums[strat] + nums[end];
                
                if( sum == 0){
                    List<Integer> in = new ArrayList();
                    in.add(nums[i]);
                    in.add(nums[strat]);
                    in.add(nums[end]);
                    ans.add(in);
                    
                    // Avoid duplicate of nums[start]
                    while (strat < end && nums[strat] == in.get(1)) strat++;
                    
                    // Avoid duplicate of nums[end]
                    while (strat < end && nums[end] == in.get(2)) end--;
                    
                }else if(sum > 0){
                    end--; 
                }else if(sum < 0){
                    strat++;
                }
                
            }
                
        }
        
        return ans;
        
    }

    }