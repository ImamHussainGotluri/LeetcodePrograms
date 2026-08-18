class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            hm.put(val,hm.getOrDefault(val,0)+1);
        }

        if(k==n){
            int max=-1;
            for(int num:nums){
                max=Math.max(max,num);
            }
            return max;
        }

        if(k==1){
            int max=-1;
            for(int num:nums){
                if(hm.get(num)==1){
                    max=Math.max(max,num);
                }
            }
            return max;
        }

        int ans1=nums[0];
        int ans2=nums[nums.length-1];
        int max=Math.max(ans1,ans2);

        if(hm.get(ans1)==1 && hm.get(ans2)==1){
            return max;
        }
        else if(hm.get(ans1)==1){
            return ans1;
        }
        else if(hm.get(ans2)==1){
            return ans2;
        }
        return -1;
    }
}