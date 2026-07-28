class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            freq[idx]++;
        }

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        StringBuilder mid=new StringBuilder();
        for(int i=0;i<26;i++){
            int cnt=freq[i];
            char ch=(char)('a'+i);
            if(cnt%2!=0){
                cnt--;
                mid.append(ch);
            }
            while(cnt>0){
                if(cnt>0){
                    cnt--;
                    sb1.append(ch);
                }

                if(cnt>0){
                    cnt--;
                    sb2.append(ch);
                }
            }
        }
        return sb1.toString()+mid.toString()+sb2.reverse().toString();
    }
}