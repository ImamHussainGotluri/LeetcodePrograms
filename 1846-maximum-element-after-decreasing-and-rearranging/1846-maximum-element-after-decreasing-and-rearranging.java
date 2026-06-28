class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        arr[0]=1;
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
                flag=false;
            }
        }
        return arr[n-1];
    }
}