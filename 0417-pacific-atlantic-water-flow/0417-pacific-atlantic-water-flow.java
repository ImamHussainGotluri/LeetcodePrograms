class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();

        int n = heights.length;
		int m = heights[0].length;
		int cnt = 0;
		
		boolean reachP[][] = new boolean[n][m];
		boolean reachQ[][] = new boolean[n][m];
		
		for (int i = 0; i<n; i++) {
			bfs(i, 0, heights, reachP, n, m);
			bfs(i,m-1, heights, reachQ, n, m);
		}
		
		for (int i = 0; i<m; i++) {
			bfs(0, i, heights, reachP, n, m);
			bfs(n- 1, i, heights, reachQ, n, m);
		}
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if (reachP[i][j] && reachQ[i][j]) {
					res.add(List.of(i, j)); 
				}
			}
		}
		
		return res;
    }
    public void bfs(int i, int j, int heights[][],boolean vis[][] ,int n, int m) {
	    
	    int row[]={-1,0,1,0};
	    int col[]={0,1,0,-1};
		Queue<Pair> que = new LinkedList<>();
		que.add(new Pair(i, j));
		vis[i][j] = true;
		while (!que.isEmpty()) {
			int r = que.peek().r;
			int c = que.peek().c;
			
			que.poll();
			
			for (int k = 0; k<4; k++) {
				int nrow = r + row[k];
				int ncol = c + col[k];
				if (nrow >= 0 && ncol >= 0 && nrow<n && ncol<m) {
					if (!vis[nrow][ncol] && heights[nrow][ncol]>=heights[r][c]) {
						que.add(new Pair(nrow, ncol));
						vis[nrow][ncol] = true;
					}
				}
			}
		}
		return;
		
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
