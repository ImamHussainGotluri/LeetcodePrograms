class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        List<List<Pair>> arr = new ArrayList<>();
        int n = online.length;
        int minCost=Integer.MAX_VALUE;
        int maxCost=Integer.MIN_VALUE;
        for (int edge[] : edges) {
            maxCost=Math.max(maxCost,edge[2]);
            minCost=Math.min(minCost,edge[2]);
        }

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(online[u] && online[v]){
                arr.get(u).add(new Pair(v, wt));
            }
            
        }

        if (n == 0 || !online[0] || !online[n - 1]) {
            return -1;
        }

        int l=minCost;
        int r=maxCost;
        int answer=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(helper(mid,arr,k,n)){
                answer=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return answer;
    }
    public boolean helper(int mid,List<List<Pair>> arr,long k,int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.wt,b.wt));
        long res[]=new long[n];
        Arrays.fill(res,Long.MAX_VALUE);
        res[0]=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int node=pq.peek().v;
            long cost=pq.peek().wt;
            pq.poll();
            if(cost>k){
                return false;
            }
            if(node==n-1){
                return cost<=k;
            }
            if(cost>res[node]){
                continue;
            }
            for(Pair adjnode:arr.get(node)){
                int newNode=adjnode.v;
                long currCost=adjnode.wt;
                if(currCost<mid){
                    continue;
                }
                long newCost=cost+currCost;
                if(newCost<res[newNode]){
                    res[newNode]=newCost;
                    pq.add(new Pair(newNode,newCost));
                }
            }
        }
        return res[n-1]<=k; 
    }
}

class Pair {
    int v;
    long wt;

    Pair(int v, long wt) {
        this.v = v;
        this.wt = wt;
    }
}