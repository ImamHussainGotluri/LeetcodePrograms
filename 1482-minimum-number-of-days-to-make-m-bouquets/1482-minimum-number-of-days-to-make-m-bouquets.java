class Solution {
     public boolean ispossible(int[] bloomDay,int m,int k,int day){
        int adj=0;
        int bouq=0;
        for(int temp:bloomDay){
            if(temp<=day){
                adj++;
                if(adj==k){
                    bouq++;
                    adj=0;
                }
            }
            else{
                adj=0;
            }

            if(bouq==m){
                return true;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int tempr=(int)Math.pow(10,9);
        int l=1;
        int r=tempr;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(ispossible(bloomDay,m,k,mid))
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        if(l==tempr+1)
        {
            return -1;
        }
        return l;
    }
}