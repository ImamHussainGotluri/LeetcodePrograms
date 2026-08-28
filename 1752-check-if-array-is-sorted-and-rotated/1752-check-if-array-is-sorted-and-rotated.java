class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;

        int k=-1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                k=i;
                break;
            }
        }

        if(k==-1){
            return true;
        }

        for(int i=k+1;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }

        if(nums[n-1]>nums[0]){
            return false;
        }

        return true;
    }
}