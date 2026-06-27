class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && obstacleGrid[i][j]==0){
                    dp[i][j]=1;
                    continue;
                }

                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }

                int left=0;
                int right=0;

                if(i>0){
                    left=dp[i-1][j];
                }
                if(j>0){
                    right=dp[i][j-1];
                }

                dp[i][j]=left+right;
            }
        }
        return dp[n-1][m-1];
    }
    // public static int helper(int sr, int sc,int dp[][],int mat[][]) {
    //     if(sr==0 && sc==0 && mat[sr][sc]!=1){
    //         return 1;
    //     }

    //     if(sr<0 || sc<0){
    //         return 0;
    //     }

    //     if(mat[sr][sc]==1){
    //         return 0;
    //     }

    //     if(dp[sr][sc]!=-1){
    //         return dp[sr][sc];
    //     }

    //     int left=helper(sr-1,sc,dp,mat);
    //     int right=helper(sr,sc-1,dp,mat);
    //     return dp[sr][sc]=left+right;
    // }
}