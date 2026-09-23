class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];

        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int tm=0;
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        int rotted=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;

            tm=Math.max(tm,t);
            q.poll();

            for(int i=0;i<4;i++){
                int row=r+drow[i];
                int col=c+dcol[i];
                if(row>=0 && col>=0 && row<n && col<m && grid[row][col]!=0 && vis[row][col]!=2){
                    q.add(new Pair(row,col,tm+1));
                    vis[row][col]=2;
                    rotted++;
                }
            }
        }

        if(fresh!=rotted){
            return -1;
        }
        return tm;
    }
}
class Pair {
    int row;
    int col;
    int tm;

    Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}