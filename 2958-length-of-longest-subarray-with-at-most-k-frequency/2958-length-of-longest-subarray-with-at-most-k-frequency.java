class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int ans=0;
        int l=0;
        for (int r = 0; r < n; r++) {
            int val = nums[r];
            hm.put(val, hm.getOrDefault(val, 0) + 1);
            while (hm.get(val) > k) {
                int prev = nums[l];
                hm.put(prev, hm.get(prev) - 1);
                if (hm.get(prev) == 0) {
                    hm.remove(prev);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}