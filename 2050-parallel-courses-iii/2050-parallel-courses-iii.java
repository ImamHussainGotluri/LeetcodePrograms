class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<=n;i++){
            res.add(new ArrayList<>());
        }

            for(int edge[]:relations){
                int u=edge[0];
                int v=edge[1];

                res.get(u).add(v);
            }

        boolean vis[]=new boolean[n+1];
        Stack<Integer> st=new Stack<>();
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                topoSort(i,vis,st,res);
            }
        }

        int dist[]=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=time[i-1];
        }
        
        
        while(!st.isEmpty()){
            int node=st.pop();
            if(dist[node]!=Integer.MIN_VALUE){
                for(int adjnode:res.get(node)){

                    if(dist[node]+time[adjnode-1]>dist[adjnode]){
                        dist[adjnode]=dist[node]+time[adjnode-1];
                    }
                }
            }
        }

        int max=0;
        for(int i=1;i<=n;i++){
            max=Math.max(max,dist[i]);
        }
        return max;
    }
    public void topoSort(int node,boolean vis[],Stack<Integer> st,List<List<Integer>> res){
        vis[node]=true;
        for(int adjnode:res.get(node)){
            
            if(!vis[adjnode]){
                topoSort(adjnode,vis,st,res);
            }
        }
        st.push(node);
    }
}