class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
		List<Integer> ans = new ArrayList<>();
		
		ans.add(nums[0]);
		
		for (int i = 1; i<n; i++) {
			
			if (nums[i]>ans.get(ans.size() - 1)) {
				ans.add(nums[i]);
			}
			else {
				int l = 0;
				int r = ans.size() - 1;
				while (l <= r) {
					int mid = l + (r - l)/2;
					if (ans.get(mid)>=nums[i]) {
						r = mid - 1;
					}
					else {
						l = mid + 1;
					}
				}
				ans.set(l, nums[i]);
			}
			
		}
		return ans.size();
    }
}