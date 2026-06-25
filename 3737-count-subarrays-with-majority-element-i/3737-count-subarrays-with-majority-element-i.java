class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            int size=0;
            for(int j=i;j<n;j++){
                size++;
                if(nums[j]==target){
                    cnt++;
                }
                if(cnt>size/2){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}