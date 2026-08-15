class Solution {
    public static boolean ispossible(int nums[],int k,int threshold){
        int sum=0;
        for(int val:nums){
            sum+=val/k;
            if(val%k!=0){
                sum++;
            }

            if(sum>threshold){
                return false;
            }
        }
        return true;
    }

    
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=(int) Math.pow(10,6);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(ispossible(nums,mid,threshold)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}