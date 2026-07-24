class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> hs=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                hs.add(nums[i]^nums[j]);
            }
        }

        Set<Integer> ans=new HashSet<>();
        for(int x:hs){
            for(int num:nums){
                ans.add(x^num);
            }
        }
        return ans.size();
    }
}