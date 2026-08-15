class Solution {
    public static boolean ispossible(int piles[],int h,int k){
        int temp=0;
        for(int pile:piles){
            temp+=pile/k;
            if(pile%k!=0){
                temp++;
            }

            if(temp>h){
                return false;
            }
        }
        return true;
    }

    
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=(int)Math.pow(10,9);
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(ispossible(piles,h,mid)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}