class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }

        int prefixSum=0;
        for(int i=0;i<n;i++){
            int suffixSum=totalSum-prefixSum-nums[i];
            if(suffixSum==prefixSum){
                return i;
            }
            prefixSum+=nums[i];
        }
        return -1;

    }
}