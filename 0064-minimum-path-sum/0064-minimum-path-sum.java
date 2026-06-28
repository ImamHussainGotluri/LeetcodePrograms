class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                    continue;
                }

                int up=(int)1e9;
                int left=(int)1e9;
                if(i>0){
                    up=grid[i][j]+dp[i-1][j];
                }

                if(j>0){
                    left=grid[i][j]+dp[i][j-1];
                }

                dp[i][j]=Math.min(up,left);
            }
        }
        return dp[n-1][m-1];
    }
    // public int getMazePath(int i, int j,int dp[][],int mat[][]) {
    //     if(i==0 && j==0){
    //        return mat[i][j];
    //     }

    //     if(i<0 || j<0){
    //         return (int)1e9;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int up=mat[i][j]+getMazePath(i-1,j,dp,mat);
    //     int left=mat[i][j]+getMazePath(i,j-1,dp,mat);
    //     dp[i][j]=Math.min(up,left);
    //     return dp[i][j];
    // }
}