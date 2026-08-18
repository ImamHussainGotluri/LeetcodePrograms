class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int max=-1;

        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            hm.put(val,hm.getOrDefault(val,0)+1);
            max=Math.max(max,val);
        }

        if(k==n){
            return max;
        }

        if(k==1){
            int maxi=-1;
            for(int num:nums){
                if(hm.get(num)==1){
                    maxi=Math.max(maxi,num);
                }
            }
            return maxi;
        }

        int ans1=nums[0];
        int ans2=nums[nums.length-1];
         max=Math.max(ans1,ans2);

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