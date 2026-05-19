class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        while(i<n1 && j<n2){
            if(nums1[i]==nums2[j]){
                min=Math.min(min,nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}