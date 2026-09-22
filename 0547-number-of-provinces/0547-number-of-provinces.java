class Solution {
    public int findCircleNum(int[][] isConnected) {
        // for(int i=0;i<n;i++){
        //     res.add(new ArrayList<>());
        // }
        // for(int i=0;i<isConnected[0].length;i++){
        //     for(int j=0;j<isConnected.length;j++){
        //         if(isConnected[i][j]!=0){
        //             res.get(i).add(j);
        //             // res.get(j).add(i);
        //         }
        //     }
        // }

        int n=isConnected[0].length;
        int cnt=0;
        boolean vis[]=new boolean[200];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,i,vis);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int mat[][],int node,boolean vis[]){
        vis[node]=true;
        for(int i=0;i<mat[0].length;i++){
            if(mat[node][i]!=0 && !vis[i]){
                dfs(mat,i,vis);
            }
        }
    }
}