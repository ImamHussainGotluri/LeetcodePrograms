class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums,target);
    }
    public int search(int nums[],int tar){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==tar){
                return mid;
            }
            else if(nums[mid]>tar){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}