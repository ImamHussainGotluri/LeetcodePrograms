class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int currSum=0;
        long result=0;
        int validLeft=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                validLeft+=hm.get(currSum);
                currSum+=1;
            }
            else{
                currSum-=1;
                validLeft-=hm.containsKey(currSum)?hm.get(currSum):0;
            }
            hm.put(currSum,hm.getOrDefault(currSum,0)+1);
            result+=validLeft;
        }
        return result;
    }
}