class Solution {
    int r;
    int c;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       
        // this.r=image.length;
        // this.c=image[0].length;
        // boolean vis[][]=new boolean[r][c];
        // fillvis(vis);

        if(image[sr][sc]==color){
            return image;
        }
        int orginalColor=image[sr][sc];
        dfs(sr,sc,image,orginalColor,color);
        return image;
    }

    // public void dfs(int sr,int sc,int image[][],boolean vis[][],int orginalColor,int color){
    //     image[sr][sc]=color;
    //           vis[sr][sc]=true;
    //     int drow[]={-1,0,1,0};
    //     int dcol[]={0,1,0,-1};
    //     for(int i=0;i<4;i++){
    //         int nrow=sr+drow[i];
    //         int ncol=sc+dcol[i];
    //         if( nrow>=0 && nrow<r && ncol>=0 && ncol<c && image[nrow][ncol]==orginalColor && vis[nrow][ncol]==false) {
    //             dfs(nrow,ncol,image,vis,orginalColor,color);
    //         }
    //     }
    // }

    public void dfs(int sr,int sc,int image[][],int orginalColor,int color){
        if(sr<0  || sc<0 || sr>=image.length || sc>=image[0].length){
            return;
        }
        
        if(image[sr][sc]!=orginalColor){
            return;
        }

        image[sr][sc]=color;

        dfs(sr+1,sc,image,orginalColor,color);
        dfs(sr-1,sc,image,orginalColor,color);
        dfs(sr,sc+1,image,orginalColor,color);
        dfs(sr,sc-1,image,orginalColor,color);
    }
   

    // public void fillvis(boolean vis[][]){
    //     for(int i=0;i<r;i++){
    //         Arrays.fill(vis[i],false);
    //     }
    // }
}