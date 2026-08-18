class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            arr[i]=xor;
        }
        int nums[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l==0){
                nums[i]=arr[r];
            }
            else{
                nums[i]=arr[r]^arr[l-1];
           }
        }
        return nums;
    }
}









































    // int xor=0;
    //     for (int i = 0; i < arr.length; i++) {
    //         xor^=arr[i];
    //         arr[i] = xor;
    //     }
    //     int nums[] = new int[queries.length];
    //     for (int i = 0; i < queries.length; i++) {
    //         int l = queries[i][0];
    //         int r = queries[i][1];
    //         if(l==0){
    //             nums[i]=arr[r];
    //         }
    //         else{
    //         nums[i] = arr[l - 1] ^ arr[r];
    //         }
    //     }
    //     return nums;