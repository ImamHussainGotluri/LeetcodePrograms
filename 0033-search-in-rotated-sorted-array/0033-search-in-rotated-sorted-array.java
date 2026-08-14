class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<=nums[mid]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[r]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    // public boolean BSearch(int l, int r, int nums[], int tar) {
    //     while (l <= r) {
    //         int mid = l + (r - l) / 2;
    //         if (nums[mid] == tar) {
    //             return true;
    //         } else if (nums[mid] > tar) {
    //             r = mid - 1;
    //         } else {
    //             l = mid + 1;
    //         }
    //     }
    //     return false;
    // }
}
