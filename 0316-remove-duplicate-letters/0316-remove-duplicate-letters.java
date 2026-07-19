class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        int pos[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            pos[ch-'a']++;
        }
        Stack<Character> st=new Stack<>();
        boolean check[]=new boolean[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            pos[ch-'a']--;
            if(check[ch-'a']){
                continue;
            }

            while(!st.isEmpty() && st.peek()>ch && pos[st.peek()-'a']>0){
                char chp=st.pop();
                check[chp-'a']=false;
            }
            st.push(ch);
            check[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}