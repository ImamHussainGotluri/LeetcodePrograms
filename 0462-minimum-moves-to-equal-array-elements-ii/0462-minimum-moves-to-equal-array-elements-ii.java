class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res=0;
		for (int i = 0; i<nums.length; i++) {
			int med = nums[i/2];
			int curr = nums[i];
			res += Math.abs(med - curr);
			
		}
        return res;
    }
}