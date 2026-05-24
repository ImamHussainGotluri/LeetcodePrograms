class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int result=1;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            result=Math.max(result,solve(arr,i,d,dp));
        }
        return result;
    }
    public int solve(int arr[],int i,int d,int dp[]){
        if(dp[i]!=-1){
            return dp[i];
        }
        int result=1;
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i]){
                break;
            }
            result=Math.max(result,1+solve(arr,j,d,dp));
        }

        for(int j=i+1;j<=Math.min(arr.length-1,i+d);j++){
            if(arr[j]>=arr[i]){
                break;
            }
            result=Math.max(result,1+solve(arr,j,d,dp));
        }
        dp[i]=result;
        return dp[i];
    }
}