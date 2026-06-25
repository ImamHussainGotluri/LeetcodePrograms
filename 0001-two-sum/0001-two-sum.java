class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int rem=target-nums[i];
            if(hm.containsKey(rem)){
                arr[0]=i;
                arr[1]=hm.get(rem);
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return arr;
    }
}