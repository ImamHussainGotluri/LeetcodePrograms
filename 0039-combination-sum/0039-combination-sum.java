class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0,new ArrayList<>());
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    public void helper(int arr[],int tar,int idx,List<Integer> ans){
        if(tar==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(idx==arr.length || tar<0){
            return;
        }

        if(arr[idx]<=tar){
            ans.add(arr[idx]);
            tar-=arr[idx];
            helper(arr,tar,idx,ans);
            ans.remove(ans.size()-1);
            tar+=arr[idx];
        }
        helper(arr,tar,idx+1,ans);
    }
}