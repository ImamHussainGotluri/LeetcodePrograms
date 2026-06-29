class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        // for(int row[]:dp){
        //     Arrays.fill(row,Integer.MAX_VALUE);
        // }
        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int up=Integer.MAX_VALUE;
                int left=Integer.MAX_VALUE;

                up=triangle.get(i).get(j)+dp[i+1][j];
                left=triangle.get(i).get(j)+dp[i+1][j+1];

                dp[i][j]=Math.min(up,left);
            }
        }
        return dp[0][0];
    }

    // public int helper(int i, int j, int n, List<List<Integer>> arr, int dp[][]) {

    //     if (i == n - 1) {
    //         return arr.get(i).get(j);
    //     }

    //     if (dp[i][j]!=Integer.MAX_VALUE) {
    //         return dp[i][j];
    //     }

    //     int up = arr.get(i).get(j) + helper(i + 1, j, n, arr, dp);
    //     int left = arr.get(i).get(j) + helper(i + 1, j + 1, n, arr, dp);
    //     return dp[i][j] = Math.min(up, left);
    // }
}