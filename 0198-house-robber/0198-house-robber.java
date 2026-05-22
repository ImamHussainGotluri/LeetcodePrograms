class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return HouseRob(nums,nums.length-1,dp);
    }
    public int HouseRob(int nums[],int n,int dp[]){
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        int left=nums[n]+HouseRob(nums,n-2,dp);

        int right=HouseRob(nums,n-1,dp);

        dp[n] = Math.max(left,right);
        return dp[n];
    }
}