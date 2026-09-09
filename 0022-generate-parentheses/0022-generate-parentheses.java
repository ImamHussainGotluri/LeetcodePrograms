class Solution {
    public List<String> generateParenthesis(int n) {
        helper(2*n,"",0);
        return res;
    }
    List<String> res=new ArrayList<>();
    public void helper(int n,String s,int idx){
        if(n==idx){
            if(check(s)){
                res.add(s);
            }
            return;
        }

        helper(n,s+'(',idx+1);
        helper(n,s+')',idx+1);
    }
    public boolean check(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || st.size()==0){
                st.push(ch);
            }
            else{
                if(st.peek()=='(' && ch==')'){
                    st.pop();
                }
            }
        }
        return st.size()==0;
    }
}