class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++)
        {
            char ch=num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            if(st.isEmpty() && ch=='0'){
                continue;
            }
            st.push(ch);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
       String result = sb.reverse().toString();
        return result.replaceFirst("0","").isEmpty() ?"0":result;
    }
}