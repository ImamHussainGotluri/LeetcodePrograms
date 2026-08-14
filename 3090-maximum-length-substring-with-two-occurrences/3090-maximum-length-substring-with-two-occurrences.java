class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        int n=s.length();
        int l=0,ans=0;
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);

            while(hm.get(ch)>2){
                char pch=s.charAt(l);
                hm.put(pch,hm.get(pch)-1);
                if(hm.get(pch)==0){
                    hm.remove(pch);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}