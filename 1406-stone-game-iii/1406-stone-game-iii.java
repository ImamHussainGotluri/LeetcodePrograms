class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int res=helper(0,stoneValue,n,dp);
        if(res>0){
            return "Alice";
        }
        else if(res<0){
            return "Bob";
        }
        return "Tie";
    }
    public int helper(int i,int stone[],int n,int []dp){
        

        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        int res=Integer.MIN_VALUE;

        res=Math.max(res,stone[i]-helper(i+1,stone,n,dp));
        if(i+1<n){
            res=Math.max(res,stone[i]+stone[i+1]-helper(i+2,stone,n,dp));
        }
        if(i+2<n){
            res=Math.max(res,stone[i]+stone[i+1]+stone[i+2]-helper(i+3,stone,n,dp));
        }
        
        return dp[i]=res;
    }
}