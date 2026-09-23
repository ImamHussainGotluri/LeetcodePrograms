class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int dist[][]=new int[n][m];

        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }

        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int val=q.peek().val;
            dist[r][c]=val;
            q.poll();

            for(int i=0;i<4;i++){
                int row=r+drow[i];
                int col=c+dcol[i];
                if(row>=0 && col>=0 && row<n && col<m && mat[row][col]==-1){
                    q.add(new Pair(row,col,val+1));
                    mat[row][col]=1;
                }
            }
        }
        return dist;
    }
}
class Pair{
    int row;
    int col;
    int val;
    Pair(int row,int col,int val){
        this.row=row;
        this.col=col;
        this.val=val;
    }
}