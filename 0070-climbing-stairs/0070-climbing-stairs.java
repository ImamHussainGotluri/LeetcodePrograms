class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return climbstairs(n,dp);
    }
    public int climbstairs(int n,int dp[]){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n]=climbstairs(n-1,dp)+climbstairs(n-2,dp);
        return dp[n];
    }
}