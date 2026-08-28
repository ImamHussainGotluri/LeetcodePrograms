class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;
        int n=nums.length;
        for(int r=0;r<n;r++){
            if(nums[l]!=nums[r]){
                l++;
                nums[l]=nums[r];
            }
        }
        return l+1;
    }
}