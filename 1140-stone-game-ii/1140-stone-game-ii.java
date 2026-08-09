class Solution {
    public int stoneGameII(int[] piles) {
        int dp[][][]=new int[2][101][101];
        for(int row[][]:dp){
            for(int col[]:row){
                Arrays.fill(col,-1);
            }
        }
        return helper(1,0,1,piles,dp);
    }
    public int helper(int alice,int i,int m,int piles[],int dp[][][]){
        if(i>=piles.length){
            return 0;
        }

        if(dp[alice][i][m]!=-1){
            return dp[alice][i][m];
        }
        int stones=0;
        int result=alice==1?-1:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(2*m,piles.length-i);x++){

            stones+=piles[i+x-1];

            if(alice==1){
                result=Math.max(result,stones+helper(0,i+x,Math.max(m,x),piles,dp));
            }
            else{
                result=Math.min(result,helper(1,i+x,Math.max(m,x),piles,dp));
            }
        }
        return dp[alice][i][m]=result;
    }
}