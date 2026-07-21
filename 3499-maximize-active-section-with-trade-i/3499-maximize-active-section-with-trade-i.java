class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> res=new ArrayList<>();

        int j=0;
        int n=s.length();
        while(j<n){
            if(s.charAt(j)=='0'){
                int start=j;
                while(j<n && s.charAt(j)=='0'){
                    j++;
                }
                res.add(j-start);
            }
            else{
                j++;
            }
        }

        int ans=0;
        for(int i=0;i<res.size()-1;i++){
            ans=Math.max(ans,res.get(i)+res.get(i+1));
        }

        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }

        return ans+ones;
    }
}