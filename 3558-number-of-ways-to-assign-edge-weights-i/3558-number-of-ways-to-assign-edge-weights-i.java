class Solution {
     int mod=1000000007;
     int maxDepth=0;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<List<Integer>> li=new ArrayList<>();

        for(int i=0;i<=n;i++){
            li.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            li.get(u).add(v);
            li.get(v).add(u);
        }

        boolean vis[]=new boolean[n+1];
        
        dfs(1,li,0,vis);
        return pow(2,maxDepth-1);

    }
    public void dfs(int node,List<List<Integer>> li,int depth,boolean vis[]){
        
        maxDepth=Math.max(depth,maxDepth);
        vis[node]=true;
        for(int u:li.get(node)){
            if(!vis[u]){
                dfs(u,li,depth+1,vis);
            } 
        }
    }
    public int pow(long base,int exp){
        long ans=1;
        while(exp>0){
            if(exp%2==1){
                ans=(ans*base)%mod;
            }
            base=(base*base)%mod;
            exp/=2;
        }
        return (int)ans;
    }
}