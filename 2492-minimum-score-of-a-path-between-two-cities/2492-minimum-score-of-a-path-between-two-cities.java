class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> arr=new ArrayList<>();
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }

        for(int edge[]:roads){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            arr.get(u).add(new Pair(v,wt));
            arr.get(v).add(new Pair(u,wt));
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        boolean vis[]=new boolean[n+1];
        vis[1]=true;
        int minCost=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int node=q.poll();
            for(Pair adjnode:arr.get(node)){
                int newNode=adjnode.u;
                int newCost=adjnode.wt;
                minCost=Math.min(newCost,minCost);
                if(!vis[newNode]){
                    vis[newNode]=true;
                    q.add(newNode);
                }
            }
        }
        return minCost;
    }
}
class Pair{
    int u;
    int wt;
    Pair(int u,int wt){
        this.u=u;
        this.wt=wt;
    }
}