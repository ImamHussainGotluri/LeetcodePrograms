class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getMazePath(m-1, n-1,dp);
    }
    public static int getMazePath(int sr, int sc,int dp[][]) {
        if(sr==0 && sc==0){
            return 1;
        }

        if(sr<0 || sc<0){
            return 0;
        }
    
        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }

        int left=getMazePath(sr-1,sc,dp);
        int right=getMazePath(sr,sc-1,dp);
        return dp[sr][sc]=left+right;
    }
}