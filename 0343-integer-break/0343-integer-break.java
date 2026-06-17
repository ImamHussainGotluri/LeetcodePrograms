class Solution {
    public int integerBreak(int n) {
        int memo[]=new int[n+1];
        return solve(n,memo);
    }
    public int solve(int n,int memo[]){
        if(n<=1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        int max=0;
        for(int i=1;i<n;i++){
            int fCut=i*(n-i);
            int futhCut=i*solve(n-i,memo);
            max=Math.max(max,Math.max(fCut,futhCut));
        }
        memo[n]=max;
        return max;
    }
}