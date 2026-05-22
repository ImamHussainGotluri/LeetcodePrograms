class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp1[]=new int[n];
        Arrays.fill(dp1,-1);
        int frstrob=Houserob(nums,1,n-1,dp1);

        int dp2[]=new int[n];
        Arrays.fill(dp2,-1);
        int notfrstrob=Houserob(nums,0,n-2,dp2);
        return Math.max(frstrob,notfrstrob);
    }
    public int Houserob(int nums[],int st,int n,int dp[]){
        if(n<0 || n<st){
            return 0;
        } 
        if(dp[n]!=-1){
            return dp[n];
        }
        int left = Houserob(nums,st,n-2,dp)+nums[n];

        int right=Houserob(nums,st,n-1,dp);

        dp[n]= Math.max(left,right);
        return dp[n];
    }
}