class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int dp[]=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<n;i++){
            int left=dp[i-1];
            int right=dp[i-2]+nums[i];
            dp[i]=Math.max(left,right);
        }
        return dp[n-1];

    }
    // public int HouseRob(int nums[],int n,int dp[]){
    //     if(n<0){
    //         return 0;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     int left=nums[n]+HouseRob(nums,n-2,dp);

    //     int right=HouseRob(nums,n-1,dp);

    //     dp[n] = Math.max(left,right);
    //     return dp[n];
    // }
}