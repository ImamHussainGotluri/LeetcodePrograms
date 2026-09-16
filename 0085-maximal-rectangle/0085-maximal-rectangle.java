class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int arr[]=new int[m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    arr[j]++;
                }
                else{
                    arr[j]=0;
                }
            }
            max=Math.max(max,histogramMax(arr));
        }
        return max;
    }
    public int histogramMax(int heights[]){
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int NSL[]=new int[n];
        int NSR[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            NSL[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            NSR[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        int area=0;
        for(int i=0;i<n;i++){
            int TotalWays=(NSR[i]-NSL[i])-1;
            int sum=TotalWays*heights[i];
            area=Math.max(area,sum);
        }
        return area;
    }
}