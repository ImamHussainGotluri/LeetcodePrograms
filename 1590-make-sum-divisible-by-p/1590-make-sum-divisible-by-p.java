class Solution {
    public int minSubarray(int[] nums, int p) {
         long total=0;
        for(int num:nums){
            total+=num;
        }

        if(total%p==0){
            return 0;
        }

        long k=total%p;
        Map<Long,Integer> hm=new HashMap<>();
        hm.put(0L,-1);
        int ans=nums.length;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(hm.containsKey((sum-k+p)%p)){
                ans=Math.min(ans,i-hm.get((sum-k+p)%p));
            }

            hm.put(sum%p,i);
        }

        return ans==nums.length?-1:ans;
    }
}