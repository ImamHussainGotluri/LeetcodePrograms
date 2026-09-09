class Solution {
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0) && dfs(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,char board[][],String word,int idx){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        
        if(board[i][j]!=word.charAt(idx)){
            return false;
        }

        if(idx==word.length()-1){
            return true;
        }

        char temp=board[i][j];
        board[i][j]='0';

        if( dfs(i-1,j,board,word,idx+1) || dfs(i+1,j,board,word,idx+1) || dfs(i,j-1,board,word,idx+1) || dfs(i,j+1,board,word,idx+1)){
            return true;
        }

        board[i][j]=temp;
        return false;
    }
}