class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st=new Stack<>();

        int n=temperatures.length;
        int res[]=new int[n];
        Arrays.fill(res,0);

        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && temperatures[i]>=st.peek().temp){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i]=st.peek().idx-i;
            }

            st.push(new Pair(temperatures[i],i));
        }

        return res;
    }
}
class Pair{
    int temp;
    int idx;
    Pair(int temp,int idx){
        this.temp=temp;
        this.idx=idx;
    }
}