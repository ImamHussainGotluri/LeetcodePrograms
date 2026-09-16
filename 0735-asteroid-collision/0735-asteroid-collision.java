class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            int temp=asteroids[i];
            boolean dest=false;
            while(!dest && !st.isEmpty() && (st.peek()>0 && temp<0)){

                if(st.peek()== -temp){
                    st.pop();
                    dest=true;
                }
                else if(-temp<st.peek()){
                    dest=true;
                }
                else if(-temp>st.peek()){
                    st.pop();
                }
            }

            if(!dest){
                st.push(temp);
            }
        }

        int res[]=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            res[i--]=st.pop();
        }

        return res;
    }
}