class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return getMazePath(m-1, n-1,dp);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i==0 && j==0){
                    dp[i][j]=1;
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
        return dp[m-1][n-1];
    }
    // public static int getMazePath(int sr, int sc,int dp[][]) {
    //     if(sr==0 && sc==0){
    //         return 1;
    //     }

    //     if(sr<0 || sc<0){
    //         return 0;
    //     }
    
    //     if(dp[sr][sc]!=-1){
    //         return dp[sr][sc];
    //     }

    //     int left=getMazePath(sr-1,sc,dp);
    //     int right=getMazePath(sr,sc-1,dp);
    //     return dp[sr][sc]=left+right;
    // }
}