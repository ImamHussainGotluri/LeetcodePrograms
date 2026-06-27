class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(n-1,m-1,dp,obstacleGrid);
    }
    public static int helper(int sr, int sc,int dp[][],int mat[][]) {
        if(sr==0 && sc==0 && mat[sr][sc]!=1){
            return 1;
        }

        if(sr<0 || sc<0){
            return 0;
        }

        if(mat[sr][sc]==1){
            return 0;
        }

        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }

        int left=helper(sr-1,sc,dp,mat);
        int right=helper(sr,sc-1,dp,mat);
        return dp[sr][sc]=left+right;
    }
}