class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;

        int total=0;
        for(int val:nums){
            total+=val;
        }

        if(total-x==0){
            return n;
        }

        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        int k=total-x;
        int ans=-1;
        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(hm.containsKey(sum-k)){
                ans=Math.max(ans,i-hm.get(sum-k));
            }

            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
        }

        if(ans==-1){
            return -1;
        }

        return n-ans;
    }
}