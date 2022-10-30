class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> set = new HashSet();
        Set<Integer> ans = new HashSet();
        
        if(n2>n1){
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        for(int i : nums1) set.add(i);
                  
        for(int i : nums2){
            if(set.contains(i)){
                ans.add(i);
            }
        }
    
        
        int op[] = new int[ans.size()];
        
        int i=0;
        for(int j: ans){
            op[i] = j;
            i++;
        }
        
        return op;
            
    }
}