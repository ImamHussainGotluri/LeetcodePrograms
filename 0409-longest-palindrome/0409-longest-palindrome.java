class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        if(hm.size()==1){
            return hm.get(s.charAt(0));
        }

        int ans=0;
        boolean hasOdd=false;
        for(int val:hm.values()){
            if(val%2==0){
                ans+=val;
            }
            else 
            {
               ans+=val-1;
               hasOdd=true;
            }
        }
        return hasOdd?ans+1:ans;
    }
}