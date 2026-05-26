class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> hs=new HashSet<>();
        int ans=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!hs.contains(ch) && Character.isUpperCase(ch)){
                char chck=Character.toLowerCase(ch);
                if(hs.contains(chck)){
                    ans++;
                }
                hs.add(ch);
            }
            else if(!hs.contains(ch) && Character.isLowerCase(ch)){
                char chck=Character.toUpperCase(ch);
                if(hs.contains(chck)){
                    ans++;
                }
                hs.add(ch);
            }
        }
        return ans;
    }
}