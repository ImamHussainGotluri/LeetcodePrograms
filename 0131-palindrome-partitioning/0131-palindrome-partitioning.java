class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(s,res,new ArrayList<>());
        return res;
    }
    public void helper(String s,List<List<String>> res,List<String> ans){
        if(s.length()==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<s.length();i++){
            String prefix=s.substring(0,i+1);
            String suffix=s.substring(i+1);
            if(checkPalindrome(prefix)){
                ans.add(prefix);
                helper(suffix,res,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public boolean checkPalindrome(String s){
        int l=0;
        int r=s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }
}