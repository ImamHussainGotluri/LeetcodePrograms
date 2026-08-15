class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        int r=Integer.MAX_VALUE;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(ispossible(weights,days,mid))
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }

    public static boolean ispossible(int weights[],int days,int cap){
        int noDays=0;
        int sum=0;
        for(int val:weights){
            if(val>cap){
                return false;
            }

            sum+=val;

            if(sum>cap){
                sum=val;
                noDays++;
            }

            if(noDays>days){
                return false;
            }
        }
        if(sum<=cap){
            noDays++;
        }
        return noDays<=days;
    }
}