class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //   if(goal==0){
        //     return atmost(nums,goal);
        //   }
        //   else{
        //    return atmost(nums,goal)- atmost(nums,goal-1);
        // }
        // }

        // public static int  atmost(int[] nums,int goal){
        //     int l=0;
        //     int temp=0;
        //     int ans=0;
        //     for(int r=0;r<nums.length;r++){
        //         temp+=nums[r];
        //         while(temp>goal){
        //             temp-=nums[l];
        //             l++;
        //         }
        //         ans+=r-l+1;
        //     }
        //     return ans;

        
        int cnt=0;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int k=goal;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                cnt+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
