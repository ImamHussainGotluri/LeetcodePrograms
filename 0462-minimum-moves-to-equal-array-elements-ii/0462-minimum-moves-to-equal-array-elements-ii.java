class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = nums[nums.length/2];
        int res=0;
		for (int i = 0; i<nums.length; i++) {
			int curr = nums[i];
			res += Math.abs(med - curr);
			
		}
        return res;
    }
}