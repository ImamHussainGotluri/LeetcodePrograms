class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, boolean[]> hm = new HashMap<>();
        for (int reserve[] : reservedSeats) {
            int row = reserve[0];
            int seat = reserve[1];
            if (!hm.containsKey(row)) {
                hm.put(row, new boolean[11]);
            }
            boolean arr[] = hm.get(row);
            arr[seat] = true;
        }

        int empty = n-hm.size();
        int cnt = 2*empty;
        for (int j:hm.keySet()) {

            boolean vis[] = hm.get(j);
            if (vis == null) {
                cnt += 2;
                continue;
            }

            boolean batch1= !vis[2] && !vis[3] && !vis[4] && !vis[5];
            boolean batch2= !vis[4] && !vis[5] && !vis[6] && !vis[7];
            boolean batch3= !vis[6] && !vis[7] && !vis[8] && !vis[9];

            if(batch1 && batch3){
                cnt+=2;
            }
            else if(batch1 || batch2 || batch3){
                cnt++;
            }

            // boolean flag = true;
            // for (int i = 2; i <= 5; i++) {
            //     if (vis[i]) {
            //         flag = false;
            //         break;
            //     }
            // }
            // if (flag) {
            //     cnt++;
            //     helper(vis, 2, 5);
            // }

            // flag = true;
            // for (int i = 4; i <= 7; i++) {
            //     if (vis[i]) {
            //         flag = false;
            //         break;
            //     }
            // }
            // if (flag) {
            //     cnt++;
            //     helper(vis, 4, 7);
            // }

            // flag = true;
            // for (int i = 6; i <= 9; i++) {
            //     if (vis[i]) {
            //         flag = false;
            //         break;
            //     }
            // }

            // if (flag) {
            //     cnt++;
            //     helper(vis, 6, 9);
            // }
        }

        return cnt;
    }

    // public void helper(boolean vis[], int i, int j) {
    //     for (int k = i; k <= j; k++) {
    //         vis[k] = true;
    //     }
    // }
}