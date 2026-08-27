class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0;
        int cnt=0;
        String ans="";
        StringBuilder sb=new StringBuilder();
        for(int r=0;r<s.length();r++){

            char ch=s.charAt(r);
            sb.append(ch);

            if(ch=='1'){
                cnt++;
            }

            while(cnt==k){
                 String curr=sb.toString();

                if (ans.isEmpty() || curr.length() < ans.length() || 
                    (curr.length() == ans.length() && curr.compareTo(ans) < 0)) {
                    ans = curr;
                }

                char prev=s.charAt(l);
                if(prev=='1'){
                    cnt--;
                }
                sb.deleteCharAt(0);
                l++;
            }

        }
        return ans;
    }
}