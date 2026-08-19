class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            res.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1]; //edges : b->a;
            res.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int vis = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            vis++;
            // for (int i = 0; i < prerequisites.length; i++) {
            //     if (prerequisites[i][1] == temp) {
            //         int node = prerequisites[i][0];
            //         indegree[node]--;
            //         if (indegree[node] == 0) {
            //             q.add(node);
            //         }
            //     }
            // }

            for(int node:res.get(temp)){
                indegree[node]--;
                if(indegree[node]==0){
                    q.add(node);
                }
            }
        }
        return vis == numCourses;
    }
}



// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

//         for (int[] pre : prerequisites)
//             adj.get(pre[1]).add(pre[0]);

//         boolean[] vis = new boolean[numCourses];
//         boolean[] path = new boolean[numCourses];

//         for (int i = 0; i < numCourses; i++)
//             if (!vis[i] && dfs(i, adj, vis, -1)) return false;

//         return true;
//     }

//     private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis,int parent) {
//         vis[node] =true;

//         for (int next : adj.get(node))
//             if (!vis[next] && dfs(next, adj, vis, parent)) return true;
//             else if (parent!=next) return true;
            
        
//         return false;
//     }
// } 