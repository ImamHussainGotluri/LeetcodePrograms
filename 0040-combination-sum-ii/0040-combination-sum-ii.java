class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0,candidates,target,new ArrayList<>());
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    public void helper(int idx,int arr[],int tar,List<Integer> ans){
        if(tar==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(idx==arr.length || tar<0){
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])
            {
                continue;
            }

            if(arr[i]<=tar){
                tar-=arr[i];
                ans.add(arr[i]);
                helper(i+1,arr,tar,ans);
                tar+=arr[i];
                ans.remove(ans.size()-1);
            }
        }
        return;
    }
}