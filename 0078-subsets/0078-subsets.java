class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        helper(0,nums,new ArrayList<>());
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    public void helper(int idx,int nums[],List<Integer> ans){
        if(idx==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[idx]);
        helper(idx+1,nums,ans);
        ans.remove(ans.size()-1);
        helper(idx+1,nums,ans);
    }
}