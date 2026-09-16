class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k){
            return "0";
        }

        Stack<Character> st=new Stack<>();
        for(char ch:num.toCharArray()){

            while(k>0 && !st.isEmpty() && ch<st.peek()){
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

        String res=sb.reverse().toString();

        return res.replaceFirst("0","").isEmpty()?"0":res;
    }
}