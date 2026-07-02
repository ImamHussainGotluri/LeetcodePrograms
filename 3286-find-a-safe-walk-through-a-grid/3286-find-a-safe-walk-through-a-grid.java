class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        int dist[][]=new int[n][m];
        for(int row[]:dist){
            Arrays.fill(row,-1);
        }
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.remHealth-a.remHealth);
        pq.add(new Pair(0,0,health-grid.get(0).get(0)));
        dist[0][0]=health-grid.get(0).get(0);
        while(!pq.isEmpty()){
            int r=pq.peek().r;
            int c=pq.peek().c;
            int currHealth=pq.peek().remHealth;
            pq.poll();
            if(r==n-1 && c==m-1 && currHealth>=1){
                return true;
            }

            if(currHealth>dist[r][c]){
                continue;
            }
            for(int i=0;i<4;i++){
                int nr=r+row[i];
                int nc=c+col[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newHealth=currHealth-grid.get(nr).get(nc);
                    if(newHealth>dist[nr][nc]){
                        dist[nr][nc]=newHealth;
                        pq.add(new Pair(nr,nc,newHealth));
                    }
                }
            }
        }
        return dist[n-1][m-1]>=1;
    }
}
class Pair{
    int r;
    int c;
    int remHealth;
    Pair(int r,int c,int remHealth){
        this.r=r;
        this.c=c;
        this.remHealth=remHealth;
    }
}