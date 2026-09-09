class Solution {
    public List<String> generateParenthesis(int n) {
        helper(n,"",0,0);
        return res;
    }
    List<String> res=new ArrayList<>();
    public void helper(int n,String s,int open,int close){
        if(2*n==open+close){
            res.add(s);
            return;
        }
        if(open<n){
            helper(n,s+'(',open+1,close);
        }

        if(close<open){
            helper(n,s+')',open,close+1);
        }
    }
    // public boolean check(String s){
    //     Stack<Character> st=new Stack<>();
    //     for(int i=0;i<s.length();i++){
    //         char ch=s.charAt(i);
    //         if(ch=='(' || st.size()==0){
    //             st.push(ch);
    //         }
    //         else{
    //             if(st.peek()=='(' && ch==')'){
    //                 st.pop();
    //             }
    //         }
    //     }
    //     return st.size()==0;
    // }
}