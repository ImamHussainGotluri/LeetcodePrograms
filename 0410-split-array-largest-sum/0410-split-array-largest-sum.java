class Solution {
    public static boolean ispossible(int nums[], int k, int ans) {

        int sum = 0;
        k--;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > ans) {
                return false;
            }
            sum += nums[i];
            if (sum > ans) {
                sum = nums[i];
                k--;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int max=0;
        int sum=0;

        for(int val:nums){
            sum+=val;
            max=Math.max(max,val);
        }

        int l=max;
        int r=sum;
        if (nums[0] == 0 && nums.length == 1) {
            return 0;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ispossible(nums, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}