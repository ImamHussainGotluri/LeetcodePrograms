class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        } 
        
        return helper(piles,0,n-1,0,0,true,dp)==1;
    }
    public int helper(int piles[],int l,int r,int alice,int bob,boolean flag,int dp[][]){
        if(l>=r){
            if(alice>bob){
                return 1;
            }
            return 0;
        }

        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        if(flag){
            int left=helper(piles,l+1,r,alice+piles[l],bob,false,dp);
            int right=helper(piles,l,r-1,alice+piles[r-1],bob,false,dp);
            dp[l][r]=(left==1 || right==1)?1:0;
        }
        else{
            int left=helper(piles,l+1,r,alice,bob+piles[l],true,dp);
            int right=helper(piles,l,r-1,alice,bob+piles[r-1],true,dp);
            dp[l][r]=(left==1 || right==1)?1:0;
        }

        return dp[l][r];
    }
}