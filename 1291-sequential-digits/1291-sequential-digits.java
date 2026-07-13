class Solution {
    
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++){
            helper(i,i-1,low,high,0,res);
        }
        Collections.sort(res);
        return res;
    }
    public void helper(int curr,int prev,int low,int high,int ans,List<Integer> res){
        if(ans>high){
            return;
        }

        if(ans>=low && ans<=high){
            res.add(ans);
        }


        for(int i=curr;i<=9;i++){
            if(i==prev+1){
                helper(i,i,low,high,ans*10+i,res);
            }
        }
    }
}