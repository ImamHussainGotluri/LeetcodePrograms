class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int res[]=new int[n];
        Arrays.fill(res,-1);

        for(int i=2*n-1;i>=0;i--){

            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i%n]=st.peek();
            }

            st.push(nums[i%n]);
        }

        return res;
    }
}