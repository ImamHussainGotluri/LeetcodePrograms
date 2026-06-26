class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getMazePath(1, 1, m, n,dp);
    }
    public static int getMazePath(int sr, int sc, int dr, int dc,int dp[][]) {
        if(sr==dr && sc==dc){
            return 1;
        }

        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }

        int cnt=0;
        if(sr<dr){
            cnt+=getMazePath(sr+1,sc,dr,dc,dp);
        }
        
        if(sc<dc){
            cnt+=getMazePath(sr,sc+1,dr,dc,dp);
        }

        dp[sr][sc]=cnt;
        return cnt;
    }
}