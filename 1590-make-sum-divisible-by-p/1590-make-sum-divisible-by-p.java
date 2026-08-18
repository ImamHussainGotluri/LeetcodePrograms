class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int val : nums) {
            total += val;
        }
        if (total % p == 0) {
            return 0;
        }
        long k = total % p;
        int ans = nums.length;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, -1);
        long presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if(hm.containsKey((presum-k+p)%p)){
                ans=Math.min(ans,i-hm.get((presum-k+p)%p));
            }
            hm.put(presum%p,i);
        }
        return ans==nums.length?-1:ans;
    }
}