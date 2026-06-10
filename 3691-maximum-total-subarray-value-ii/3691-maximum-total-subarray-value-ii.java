class Solution {
    SegmentTree st;
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        st=new SegmentTree(nums);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(b.val,a.val));
        for(int l=0;l<n;l++){
            int val=st.queryMax(l,n-1)-st.queryMin(l,n-1);
            pq.add(new Pair(l,n-1,val));
        }

        long result=0;
        while(k>0){
            Pair node=pq.poll();
            int l=node.l;
            int r=node.r;
            long val=node.val;
            result+=val;
            if(l<=r-1){
                long nval=st.queryMax(l,r-1)-st.queryMin(l,r-1);
                pq.add(new Pair(l,r-1,nval));
            }
            k--;
        }
        return result;
    }
}
class Pair{
    int l;
    int r;
    long val;
    Pair(int l ,int r,long val){
        this.l=l;
        this.r=r;
        this.val=val;
    }
}

class SegmentTree{
    int minTree[];
    int maxTree[];
    int nums[];
    int n;
    SegmentTree(int nums[]){
        this.nums=nums;
        this.n=nums.length;
        minTree=new int[4*n];
        maxTree=new int[4*n];
        build(0,0,n-1);
    }
    void build(int node,int start,int end){
        if(start==end){
            minTree[node]=nums[start];
            maxTree[node]=nums[start];
            return;
        }

        int mid=start+(end-start)/2;

        build(2*node+1,start,mid);
        build(2*node+2,mid+1,end);

        minTree[node]=Math.min(minTree[2*node+1],minTree[2*node+2]);
        maxTree[node]=Math.max(maxTree[2*node+1],maxTree[2*node+2]);
    }

    int queryMin(int l,int r){
        return queryMinUtil(0,0,n-1,l,r);
    }

    int queryMinUtil(int node,int start,int end,int l,int r){
        if(end<l || start>r){
            return Integer.MAX_VALUE;
        }

        if(l<=start && end<=r){
            return minTree[node];
        }

        int mid=start+(end-start)/2;

        int left = queryMinUtil(2*node+1,start,mid,l,r);
        int right=queryMinUtil(2*node+2,mid+1,end,l,r);

        return Math.min(left,right);
    }

    int queryMax(int l,int r){
        return queryMaxUtil(0,0,n-1,l,r);
    }

    int queryMaxUtil(int node,int start,int end,int l,int r){
    if(end < l || start > r){
        return Integer.MIN_VALUE;
    }

    if(l <= start && end <= r){
        return maxTree[node];
    }

    int mid = start + (end - start) / 2;

    int left = queryMaxUtil(2 * node + 1, start, mid, l, r);
    int right = queryMaxUtil(2 * node + 2, mid + 1, end, l, r);

    return Math.max(left, right);
}
}