class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1,k,n,new ArrayList<>());
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    public void helper(int idx,int k,int tar,List<Integer> ans){
        if(ans.size()==k && tar==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(tar<0){
            return;
        }

        for(int i=idx;i<=9;i++){

            if(i>tar){
                break;
            }

            tar-=i;
            ans.add(i);
            helper(i+1,k,tar,ans);
            tar+=i;
            ans.remove(ans.size()-1);
        }
    }
}