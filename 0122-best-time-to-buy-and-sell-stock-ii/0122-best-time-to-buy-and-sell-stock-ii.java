class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,1,prices,n, dp);
    }
    public int helper(int idx,int buy,int prices[],int n,int dp[][]){
        if(n==idx){
            return 0;
        }

        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(-prices[idx]+helper(idx+1,0,prices,n,dp),helper(idx+1,1,prices,n,dp));
        }
        else{
            profit=Math.max(prices[idx]+helper(idx+1,1,prices,n,dp),helper(idx+1,0,prices,n,dp));
        }
        return dp[idx][buy]=profit;
    }
}