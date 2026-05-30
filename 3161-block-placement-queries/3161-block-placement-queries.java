// class Solution {
//     public List<Boolean> getResults(int[][] queries) {
//         List<Boolean> res=new ArrayList<>();
//         TreeSet<Integer> tr=new TreeSet<>();

//         for(int arr[]:queries){
//             if(arr[0]==1){
//                 tr.add(arr[1]);
//             }
//             else{
//                 int x=arr[1];
//                 int sz=arr[2];
//                 int prev=0;
//                 boolean flag=false;
//                 for(int val:tr){
//                     if(val>x){
//                         break;
//                     }

//                     int curr=val;
//                     if(curr-prev>=sz){
//                         res.add(true);
//                         flag=true;
//                         break;
//                     }
//                     prev=curr;
//                 }
//                 if(!flag && x-prev>=sz){
//                     res.add(true);
//                 }
//                 else if(!flag){
//                     res.add(false);
//                 }
//             }
//         }
//         return res;
//     }
// }


class Solution {
    int[] segmentTree;
    int n = 50000;

    void constructSegmentTree() {
        segmentTree = new int[4 * n];
    }

    void updateSegTree(int idx, int val, int i, int l, int r) {
        if(l == r) {
            segmentTree[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if(idx <= mid) {
            updateSegTree(idx, val, 2*i+1, l, mid);
        } else {
            updateSegTree(idx, val, 2*i+2, mid+1, r);
        }

        segmentTree[i] = Math.max(segmentTree[2*i+1], segmentTree[2*i+2]);
    }

    int querySegTree(int start, int end, int i, int l, int r) {
        if(l > end || r < start) {
            return 0;
        }

        if(l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;

        return Math.max(querySegTree(start, end, 2*i+1, l, mid),
                        querySegTree(start, end, 2*i+2, mid+1, r));
    }

    public List<Boolean> getResults(int[][] queries) {
        constructSegmentTree();

        TreeSet<Integer> st = new TreeSet<>();
        st.add(0);

        List<Boolean> result = new ArrayList<>();

        for(int[] query : queries) {
            if(query[0] == 1) {
                int x = query[1];

                Integer nxtVal = st.higher(x);
                int nxt = (nxtVal != null) ? nxtVal : -1;
                int pre = st.lower(x) != null ? st.lower(x) : st.floor(x);

                updateSegTree(x, x - pre, 0, 0, n - 1);
                if(nxt != -1) updateSegTree(nxt, nxt - x, 0, 0, n - 1);

                st.add(x);
            } else {
                int x = query[1];
                int sz = query[2];

                int pre = st.floor(x);

                int maxGap = querySegTree(0, pre, 0, 0, n - 1);
                int best = Math.max(maxGap, x - pre);

                result.add(best >= sz);
            }
        }

        return result;
    }
}