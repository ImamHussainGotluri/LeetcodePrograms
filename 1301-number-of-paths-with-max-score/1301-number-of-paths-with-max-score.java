class Solution {
    int mod=1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int m=board.get(0).length();
        int dp[][][]=new int[n][m][2];
        for(int row[][]:dp){
            for(int col[]:row){
                Arrays.fill(col,-1);
            }
        }
        return helper(n-1,m-1,board,dp);
    }
    public int[] helper(int i,int j,List<String> board,int dp[][][]){
        if(board.get(i).charAt(j)=='E'){
            return new int[]{0,1};
        }

        if(board.get(i).charAt(j)=='X'){
            return new int[]{0,0};
        }

        if(dp[i][j][0]!=-1){
            return dp[i][j];
        }

        int upScore=0,upPath=0;
        int leftScore=0,leftPath=0;
        int diagScore=0,diagPath=0;

        char ch=board.get(i).charAt(j);
        
        if(isValid(i-1,j,board)){
            int res[]=helper(i-1,j,board,dp);
            upScore=res[0];
            upPath=res[1];
            if(upPath>0){
                upScore+=ch=='S'?0:ch-'0';
            }
        }
        if(isValid(i,j-1,board)){
            int res[]=helper(i,j-1,board,dp);
            leftScore=res[0];
            leftPath=res[1];
            if(leftPath>0){
                leftScore+=ch=='S'?0:ch-'0';
            }
        }
        if(isValid(i-1,j-1,board)){
            int res[]=helper(i-1,j-1,board,dp);
            diagScore=res[0];
            diagPath=res[1];
            if(diagPath>0){
                diagScore+=ch=='S'?0:ch-'0';
            }
        }

        int bestScore=0,bestPath=0;
        if(leftScore==upScore && upScore==diagScore){
            bestScore=leftScore;
            bestPath=leftPath+upPath+diagPath;
        }
        else if(leftScore==upScore){
            bestScore=upScore;
            bestPath=leftPath+upPath;
            if(diagScore>bestScore || diagScore==bestScore && diagPath>bestPath){
                bestScore=diagScore;
                bestPath=diagPath;
            }
        }
        else if(leftScore==diagScore){
            bestScore=leftScore;
            bestPath=leftPath+diagPath;
            if(upScore>bestScore || upScore==bestScore && upPath>bestPath){
                bestScore=upScore;
                bestPath=upPath;
            }
        }
        else{
            bestScore=upScore;
            bestPath=upPath;
            if(leftScore>bestScore || leftScore==bestScore && leftPath>bestPath){
                bestScore=leftScore;
                bestPath=leftPath;
            }

            if(diagScore>bestScore || diagScore==bestScore && diagPath>bestPath){
                bestScore=diagScore;
                bestPath=diagPath;
            }
        }
        dp[i][j][0]=bestScore;
        dp[i][j][1]=bestPath%mod;
        return dp[i][j];
    }
    public boolean isValid(int i,int j,List<String> board){
       int n=board.size();
       int m=board.get(0).length();
       if(i>=0 && j>=0 && i<n && j<m){
        return true;
       }
       return false;
    }
}