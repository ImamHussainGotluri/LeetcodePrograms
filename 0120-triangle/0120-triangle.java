class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return helper(0, 0, n,triangle , dp);
    }

    public int helper(int i, int j, int n, List<List<Integer>> arr, int dp[][]) {

        if (i == n - 1) {
            return arr.get(i).get(j);
        }

        if (dp[i][j]!=Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int up = arr.get(i).get(j) + helper(i + 1, j, n, arr, dp);
        int left = arr.get(i).get(j) + helper(i + 1, j + 1, n, arr, dp);
        return dp[i][j] = Math.min(up, left);
    }
}