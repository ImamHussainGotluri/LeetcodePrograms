class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int freq[]=new int[26];

        for(int i=0;i<word1.length();i++){
            int idx=word1.charAt(i)-'a';
            freq[idx]++;
        }

        for(int i=0;i<word2.length();i++){
            int idx=word2.charAt(i)-'a';
            freq[idx]--;
        }

        for(int i=0;i<26;i++){
            if(Math.abs(freq[i])>3){
                return false;
            }
        }
        return true;
    }
}