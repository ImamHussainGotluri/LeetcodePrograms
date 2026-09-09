class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0,nums,new ArrayList<>());
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    public void helper(int idx,int nums[],List<Integer> ans){
        res.add(new ArrayList<>(ans));
       

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i-1]==nums[i]){
                continue;
            }

            ans.add(nums[i]);
            helper(i+1,nums,ans);
            ans.remove(ans.size()-1);
        }
    }
}