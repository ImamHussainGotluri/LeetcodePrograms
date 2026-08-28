class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int n=words.length;
        int prefix[]=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(check(words[i])){
                cnt++;
            }
            prefix[i]=cnt;
        }
        if(left==0){
            return prefix[right];
        }
        return prefix[right]-prefix[left-1];
    }
    public boolean check(String s){
        char ch1=s.charAt(0);
        char ch2=s.charAt(s.length()-1);

        if((ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u') && (ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u')){
            return true;
        }
        return false;
    }
}