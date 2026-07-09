class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m=queries.length;
        boolean ans[]=new boolean[m];
        int id=0;
        int connect[]=new int[n];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>maxDiff){
                id++;
            }
            connect[i]=id;
        }

        for(int k=0;k<m;k++){
            int u=queries[k][0];
            int v=queries[k][1];

            if(connect[u]==connect[v]){
                ans[k]=true;
            }
        }
        return ans;
        // List<List<Integer>> res=new ArrayList<>();

        // for(int i=0;i<n;i++){
        //     res.add(new ArrayList<>());
        // }

        // int i=0;
        // int j=1;
        // while(j<nums.length){
        //     if(i==j){
        //         j++;
        //     }
        //     else if(nums[j]-nums[i]>maxDiff){
        //         i++;
        //     }
        //     else{
        //         res.get(i).add(j);
        //         res.get(j).add(i);
        //         j++;
        //     }
        // }

        // int k=0;
        // for(int query[]:queries){
        //     int u=query[0];
        //     int v=query[1];

        //     boolean vis[]=new boolean[n];
        //     dfs(res,vis,u);
        //     ans[k++]=vis[v]&&vis[u]?true:false;
        // }
        // return ans;
    }
    // public void dfs(List<List<Integer>> res,boolean vis[],int node){
    //     vis[node]=true;
    //     for(int adjnode:res.get(node)){
    //         if(!vis[adjnode]){
    //             dfs(res,vis,adjnode);
    //         }
    //     }
    // }
}