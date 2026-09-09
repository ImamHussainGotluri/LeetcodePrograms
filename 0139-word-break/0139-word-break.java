class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Boolean memo[]=new Boolean[n+1];
        Set<String> hs=new HashSet<>(wordDict);
        return WordBreak(0,memo,s,hs);
    }
    public static boolean WordBreak(int idx,Boolean memo[],String s,Set<String> hs){
        if(s.length()==idx){
            return true;
        }
        if(memo[idx]!=null){
            return memo[idx];
        }

        for(int i=idx+1;i<=s.length();i++){
            String prefix=s.substring(idx,i);
            if(hs.contains(prefix) && WordBreak(i,memo,s,hs)){
                return memo[idx]=true;
            }
        }
        return memo[idx]=false;
    }
}