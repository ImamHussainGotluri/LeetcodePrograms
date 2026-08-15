class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = nums[0];
        int cnt = nums[0] == 0 ? 1 : 0;
        for (int r = 1; r < nums.length; r++) {
            xor ^= nums[r];
            if (nums[r] == 0) {
                cnt++;
            }
        }
        if (cnt == n) {
            return 0;
        }
        if (xor == 0) {
            return n - 1;
        }
        return n;
    }
}