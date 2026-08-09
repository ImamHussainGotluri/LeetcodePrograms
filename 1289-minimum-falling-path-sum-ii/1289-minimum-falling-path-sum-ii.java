class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return helper(grid, n - 1, n, dp);
    }

    public int helper(int mat[][], int i, int prev, int dp[][]) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < mat.length; j++) {
            if (prev != j) {
                min = Math.min(min, mat[i][j] + helper(mat, i - 1, j, dp));
            }
        }
        return dp[i][prev] = min;
    }
}