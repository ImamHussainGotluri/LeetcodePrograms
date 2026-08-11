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

        for(int i=seq;i<=10000;i++){
            if(!hs.contains(i)){
                return i;
            }
        }
        return 0;
    }
}