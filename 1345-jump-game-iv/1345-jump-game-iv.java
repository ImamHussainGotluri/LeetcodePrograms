class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1){
            return 0;
        }
        Map<Integer,ArrayList<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<n;i++){
            hm.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        boolean vis[]=new boolean[n];
        vis[0]=true;
        while(!q.isEmpty()){
            int node=q.peek().node;
            int wt=q.peek().wt;
            q.poll();
            if(node==n-1){
                return wt;
            }
            if(node-1>=0 && !vis[node-1]){
                q.add(new Pair(node-1,wt+1));
                vis[node-1]=true;
            }
            if(node+1<n && !vis[node+1]){
                q.add(new Pair(node+1,wt+1));
                vis[node+1]=true;
            }
            if(hm.containsKey(arr[node])){
                    for(int adjnode:hm.get(arr[node])){
                        if(!vis[adjnode]){
                            vis[adjnode]=true;
                            q.add(new Pair(adjnode,wt+1));
                        }
                    }
                hm.remove(arr[node]);
            }
        }
        return -1;
    }
}
class Pair{
    int node;
    int wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}