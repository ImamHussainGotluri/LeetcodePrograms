class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int edge[] : invocations) {
            int u = edge[0];
            int v = edge[1];

            res.get(u).add(v);
        }

        boolean vis[] = new boolean[n];
        dfs(k, vis, res);


        

        for(int edge[]:invocations){
            int u=edge[0];
            int v=edge[1];

            if(!vis[u] && vis[v]){
                List<Integer> allres=new ArrayList<>();
               for(int i=0;i<n;i++){
                allres.add(i);
               }
               return allres;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public void dfs(int node, boolean vis[], List<List<Integer>> res) {
        vis[node] = true;

        for (int adjnode : res.get(node)) {
            if (!vis[adjnode]) {
                dfs(adjnode, vis, res);
            }
        }
    }
}