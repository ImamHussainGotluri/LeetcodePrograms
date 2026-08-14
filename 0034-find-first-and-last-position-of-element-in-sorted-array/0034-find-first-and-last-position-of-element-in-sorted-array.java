class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftPos(nums,target),rightPos(nums,target)};
    }
    public int leftPos(int nums[],int tar){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]>=tar){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        if(l<nums.length && nums[l]==tar){
            return l;
        }
        return -1;
    }
    public int rightPos(int nums[],int tar){
        int l=0;
        int r=nums.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]>tar){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        if(r>=0 && nums[r]==tar){
            return r;
        }
        return -1;
    }
}