class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return helper(0, n - 1, nums, 0, 0, true);
    }

    public boolean helper(int l, int r, int nums[], int p1, int p2, boolean isPlayer1) {
        if (l > r) {
            if (p1 >= p2) {
                return true;
            }
            return false;
        }

        if (isPlayer1) {
            return helper(l + 1, r, nums, p1 + nums[l], p2, false) || helper(l, r - 1, nums, p1 + nums[r], p2, false);
        } else {
            return helper(l + 1, r, nums, p1, p2 + nums[l], true) && helper(l, r - 1, nums, p1, p2 + nums[r], true);
        }
    }
}