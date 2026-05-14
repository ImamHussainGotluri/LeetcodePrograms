class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        if(hm.getOrDefault(n-1,0)!=2){
            return false;
        }
        for(int i=1;i<=n-2;i++){
            if(!hm.containsKey(i) || hm.get(i)>1){
                return false;
            }
        }
        return true;
    }
}