class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res="";
        for(String s:words){
            int sum=0;
            for(int i=0;i<s.length();i++){
                int idx=s.charAt(i)-'0'-49;
                sum+=weights[idx];
            }
            char ch=(char)(122-(sum%26));
            res+=ch;
        }
        return res;
    }
}