class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int xor=0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            arr[i]=xor;
        }

        int n=queries.length;

        int ans[]=new int[n];
        int j=0;
        for(int query[]:queries){
            int l=query[0];
            int r=query[1];

            if(l==0){
                ans[j]=arr[r];
            }
            else{
                ans[j]=arr[r]^arr[l-1];
            }

            j++;
        }

        return ans;
    }
}
