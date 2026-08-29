class Solution {
    public char findTheDifference(String s, String t) {
        int freq[]=new int[26];
        for(char ch:t.toCharArray()){
            int idx=ch-'a';
            freq[idx]++;
        }

        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            freq[idx]--;
        }

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                return (char)(i+'a');
            }
        }

        return 'a';
    }
}