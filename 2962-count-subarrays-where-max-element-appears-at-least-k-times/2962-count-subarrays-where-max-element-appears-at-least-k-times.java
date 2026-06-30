class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int n = nums.length;
        long total = ((long)n * (n + 1)) / 2;
        int l = 0;
        long ans = 0;
        long cnt = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max) {
                cnt++;
            }

            while (cnt >= k) {
                if (nums[l] == max) {
                    cnt--;
                }
                l++;
            }
            ans+=r-l+1;
        }
        return total - ans;
    }
}