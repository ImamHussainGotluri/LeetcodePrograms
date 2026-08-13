class Solution {
    class Node{
        int pre=0;
        int suf=0;
        int maxLen=0;
        char leftchar;
        char rightchar;
        Node(int pre,int suf,int maxLen,char leftchar,char rightchar){
            this.pre=pre;
            this.suf=suf;
            this.maxLen=maxLen;
            this.leftchar=leftchar;
            this.rightchar=rightchar;
        }
        Node(){}
    }
    Node merge(Node L,Node R,int leftLen,int rightLen){
        Node res=new Node();

        res.leftchar=L.leftchar;
        res.rightchar=R.rightchar;

        res.pre=L.pre;
        if(L.pre==leftLen && L.rightchar==R.leftchar){
            res.pre=L.pre+R.pre;
        }

        res.suf=R.suf;
        if(R.suf==rightLen && L.rightchar==R.leftchar){
            res.suf=L.suf+R.suf;
        }

        res.maxLen=Math.max(L.maxLen,R.maxLen);

        if(L.rightchar==R.leftchar){
            res.maxLen=Math.max(res.maxLen,L.suf+R.pre);
        }
        return res;
    }
    int n;
    Node segmentTree[];
    void buildSegmentTree(int i,int l,int r,String s){
        if(l==r){
            segmentTree[i]=new Node(1,1,1,s.charAt(l),s.charAt(l));
            return;
        }

        int mid=l+(r-l)/2;

        buildSegmentTree(2*i+1,l,mid,s);
        buildSegmentTree(2*i+2,mid+1,r,s);

        segmentTree[i]=merge(segmentTree[2*i+1],segmentTree[2*i+2],mid-l+1,r-mid);

    }
    void update(int i,int l,int r,int pos,char ch){
        if(l==r){
            segmentTree[i]=new Node(1,1,1,ch,ch);
            return;
        }

        int mid=l+(r-l)/2;

        if(pos<=mid){
            update(2*i+1,l,mid,pos,ch);
        }
        else{
            update(2*i+2,mid+1,r,pos,ch);
        }

        segmentTree[i]=merge(segmentTree[2*i+1],segmentTree[2*i+2],mid-l+1,r-mid);
    }
    
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n=s.length();
        segmentTree=new Node[4*n];
        buildSegmentTree(0,0,n-1,s);

        int k=queryIndices.length;
        int result[]=new int[k];
        for(int i=0;i<k;i++){
            char ch=queryCharacters.charAt(i);
            int pos=queryIndices[i];
            update(0,0,n-1,pos,ch);

            result[i]=segmentTree[0].maxLen;
        }
        return result;
    }
}