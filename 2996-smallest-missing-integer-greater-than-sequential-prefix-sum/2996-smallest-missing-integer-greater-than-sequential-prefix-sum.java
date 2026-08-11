class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> hs=new HashSet<>();
        int sum=0;
        for(int num:nums){
            hs.add(num);
            sum+=num;
        }

        int seq=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                seq+=nums[i];
            }
            else{
               break;
            }
        }

        while(hs.contains(seq)){
            seq++;
        }
        return seq;
    }
}