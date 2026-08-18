class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;

        int total=0;
        for(int num:nums){
            total+=num;
        }

        if(total-x==0){
            return n;
        }

        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);

        int ans=-1;
        int sum=0;
        int tar=total-x;
        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(hm.containsKey(sum-tar)){
                ans=Math.max(ans,i-hm.get(sum-tar));
            }
            
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
        }
        if(ans==-1){
            return ans;
        }
        return n-ans;
    }
}