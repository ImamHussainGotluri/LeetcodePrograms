class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[]=s.split(" ");
        if(pattern.length()!=str.length){
            return false;
        }

        Map<Character,String> chars=new HashMap<>();
        Map<String,Character> words=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=str[i];

            if(chars.containsKey(ch)){
                if(!chars.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                chars.put(ch,word);
            }

            if(words.containsKey(word)){
                if(words.get(word)!=ch){
                    return false;
                }
            }
            else{
                words.put(word,ch);
            }
        }
        return true;
    }
}