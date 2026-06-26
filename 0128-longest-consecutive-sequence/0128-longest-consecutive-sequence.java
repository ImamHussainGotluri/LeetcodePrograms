class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        // int lastsmall=Integer.MIN_VALUE;
        // int ans=1;
        // int cnt=0;
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]-1==lastsmall){
        //         cnt++;
        //         lastsmall=nums[i];
        //     }
        //     else if(nums[i]!=lastsmall){
        //         cnt=1;
        //         lastsmall=nums[i];
        //     }
        //     ans=Math.amx(ans,cnt);
        // }
        // return ans; 


        HashSet<Integer> hs=new HashSet<>();
        
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        } 


        for(int num:hs){
            int cnt=0;
            if(!hs.contains(num-1)){
                int curr=num;
                while(hs.contains(curr)){
                    cnt++;
                    curr++;
                }
            }
            ans=Math.max(ans,cnt);
        }
       return ans;
    }
}