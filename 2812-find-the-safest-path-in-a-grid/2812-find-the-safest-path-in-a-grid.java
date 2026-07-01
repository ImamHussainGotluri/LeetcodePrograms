class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        int dist[][] = new int[n][n];
        for (int row[] : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        int row[] = { -1, 0, 1, 0 };
        int col[] = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int r = q.peek().r;
            int c = q.peek().c;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = r + row[i];
                int ncol = c + col[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n) {
                    if (dist[nrow][ncol]==(int) 1e9) {
                        dist[nrow][ncol] = dist[r][c] + 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }

        PriorityQueue<Apair> pq = new PriorityQueue<>((a, b) -> b.safeness - a.safeness);
        pq.add(new Apair(0, 0, dist[0][0]));
        int bestSafe[][] = new int[n][n];

        for (int roww[] : bestSafe) {
            Arrays.fill(roww, (int) 1e9);
        }
        bestSafe[0][0]=dist[0][0];
        while (!pq.isEmpty()) {
            int r = pq.peek().r;
            int c = pq.peek().c;
            int currSafe = pq.peek().safeness;
            pq.poll();
            if(r==n-1 && c==n-1){
                return currSafe;
            }
            if(currSafe<bestSafe[r][c]){
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    int newSafe=Math.min(currSafe,dist[nr][nc]);
                    if(newSafe < bestSafe[nr][nc]){
                        bestSafe[nr][nc]=newSafe;
                        pq.add(new Apair(nr,nc,newSafe));
                    }
                }
            }
        }
        return bestSafe[n-1][n-1];
    }
}

class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Apair {
    int r;
    int c;
    int safeness;

    Apair(int r, int c, int safeness) {
        this.r = r;
        this.c = c;
        this.safeness = safeness;
    }
}