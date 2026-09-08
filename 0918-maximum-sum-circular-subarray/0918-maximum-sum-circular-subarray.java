class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int currMax=0;
        int currMin=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int total=0;
        
        for(int i=0;i<n;i++){
            total+=nums[i];

            currMax+=nums[i];
            maxSum=Math.max(maxSum,currMax);
            if(currMax<0){
                currMax=0;
            }

            currMin+=nums[i];
            minSum=Math.min(minSum,currMin);
            if(currMin>0){
                currMin=0;
            }
        }

        if(maxSum<0){
            return maxSum;
        }

        return Math.max(maxSum,total-minSum);
    }
}