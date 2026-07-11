class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            res.get(u).add(v);
            res.get(v).add(u);
        }

        boolean vis[]=new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
               int arr[]=new int[2];
               dfs(res,vis,i,arr);
               int nodes=arr[0];
               int edge=arr[1]/2;
               if((nodes*(nodes-1)/2)==edge){
                cnt++;
               }
            }
        }
        return cnt;
    }

    public int[] dfs(List<List<Integer>> res,boolean vis[],int node,int arr[]){
         vis[node]=true;
         arr[0]+=1;
         arr[1]+=res.get(node).size();
         for(int adjnode:res.get(node)){
            if(!vis[adjnode]){
                dfs(res,vis,adjnode,arr);
            }
         }
         return arr;
    }
    
}
