class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> arr=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            arr.get(u).add(v);
        }

        long memo[]=new long[n];
        Arrays.fill(memo,-1);
        return dfs(0,arr,baseTime,memo);
    }  
    public long dfs(int node,List<List<Integer>> arr,int baseTime[],long memo[]){
        if(memo[node]!=-1){
            return memo[node];
        }
        if(arr.get(node).isEmpty()){
            memo[node]=baseTime[node];
            return memo[node];
        }

        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        for(int child:arr.get(node)){
            long leaf=dfs(child,arr,baseTime,memo);
            max=Math.max(max,leaf);
            min=Math.min(min,leaf);
        }
        long own=(max-min)+baseTime[node];
        memo[node]=own+max;
        return  memo[node];
    }
}