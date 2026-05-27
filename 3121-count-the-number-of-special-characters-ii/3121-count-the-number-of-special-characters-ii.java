class Solution {
    public int numberOfSpecialChars(String word) {
        boolean lower[]=new boolean[26];
        boolean upper[]=new boolean[26];
        int ans=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch)){
                char sch=Character.toUpperCase(ch);
                if(lower[ch-'a'] && upper[sch-'A']){
                    ans-=1;
                    lower[ch-'a']=false;
                    continue;
                }
                else if(upper[sch-'A']){
                    continue;
                }
                lower[ch-'a']=true;
            }
            else{
                char lch=Character.toLowerCase(ch);
                if(lower[lch-'a'] && upper[ch-'A']){
                    continue;
                }
                else if(lower[lch-'a']){
                    ans++;
                }
                upper[ch-'A']=true;
            }
        }
        return ans;
    }
}