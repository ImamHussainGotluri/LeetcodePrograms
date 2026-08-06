class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
		int ans = 0;
		while (true) {
		    int zeros = 0;
			boolean check = false;
			for (int i = 0; i<n; i++) {
				if (nums[i] == 0) {
					zeros++;
				}
				else if (nums[i]%2 != 0) {
					check = true;
					break;
				}
			}
			
			if(zeros==n){
			    break;
			}
			
			if (check) {
				for (int i = 0; i<nums.length; i++) {
					if (nums[i]%2 != 0) {
						nums[i] --;
						ans++;
						
					}
				}
			}
			else {
				ans++;
				for (int i = 0; i<nums.length; i++) {
					int ele = nums[i];
					nums[i] = ele/2;
				}
			}
			
		}
		return ans;
    }
}