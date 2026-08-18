class Solution {
    public int minStartValue(int[] nums) {
        int l=1;
        int r=100000;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(helper(nums,mid)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean helper(int nums[],int start){
        
        for(int num:nums){
            int temp=start+num;
            start=temp;

            if(start<1){
                return false;
            }
        }
        return true;
    }
}