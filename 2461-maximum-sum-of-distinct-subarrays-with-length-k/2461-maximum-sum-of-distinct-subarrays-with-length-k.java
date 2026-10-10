class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max=0;
        Map<Integer,Integer> hm=new HashMap<>();
        int l=0;
        long sum=0;
        for(int r=0;r<nums.length;r++)
        {
            sum+=nums[r];
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);

            while(hm.get(nums[r])>1 || r-l+1>k){
                sum-=nums[l];
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            // while(r-l+1>k){
            //     hm.put(nums[l],hm.get(nums[l])-1);
            //     if(hm.get(nums[l])==0){
            //         hm.remove(nums[l]);
            //     }
            //     sum-=nums[l];
            //     l++;
            // }
            if(r-l+1==k){
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}