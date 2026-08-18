class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0,max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]==1?1:-1;
            if(hm.containsKey(sum)){
                max=Math.max(max,i-hm.get(sum));
            }

            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
        }
        return max;
    }
}