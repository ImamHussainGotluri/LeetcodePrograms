class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<List<Pair>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int val=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    res.get(i).add(new Pair(j,val));
                    res.get(j).add(new Pair(i,val));
                }
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Pair(0,0));
        int sum=0;
        boolean vis[]=new boolean[n+1];
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int val=pq.peek().dis;
            pq.poll();
            if(vis[node]){
                continue;
            }
            sum+=val;
            vis[node]=true;
            for(Pair adjnode:res.get(node)){
                int anode=adjnode.node;
                int nval=adjnode.dis;
                if(!vis[anode]){
                    pq.add(new Pair(anode,nval));
                }
            }
        }
        return sum;
    }
}
class Pair{
    int node;
    int dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}