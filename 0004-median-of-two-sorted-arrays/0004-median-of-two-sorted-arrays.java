class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        
        if(n==0 && n==m) return 0;
        
        double [] merged = new double[n+m];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<n && j<m){
            
            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i];
                i++;
            }else{
                merged[k++] = nums2[j];
                j++;
            }
            
        }
        
        if(i==n){
            while(j<m){
                merged[k++] = nums2[j];
                j++;
            }
        }
        
        if(j==m){
            while(i<n){
                merged[k++] = nums1[i];
                i++;
            }
        }
        
        //System.out.println(Arrays.toString(merged));
        
        int mid = (m+n)/2;
        
        if((m + n) % 2 == 0){
            //System.out.println((merged[mid] + merged[mid-1]) / 2);
            return (merged[mid] + merged[mid-1]) / 2;     
        }else{
            return merged[mid];
        }
        
        
    }
}