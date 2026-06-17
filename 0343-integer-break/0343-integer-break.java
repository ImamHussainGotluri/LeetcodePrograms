class Solution {
    public int integerBreak(int n) {
        if(n<=1){
            return 0;
        }
        if(n==2 || n==3){
            return n-1;
        }
        int prod=1;
        while(n>4){
            prod=prod*3;
            n-=3;
        }
        return prod*n;
    }
    // public int solve(int n,int memo[]){
    //     if(n<=1){
    //         return 0;
    //     }
    //     if(n==2){
    //         return 1;
    //     }
    //     if(memo[n]!=0){
    //         return memo[n];
    //     }
    //     int max=0;
    //     for(int i=1;i<n;i++){
    //         int fCut=i*(n-i);
    //         int futhCut=i*solve(n-i,memo);
    //         max=Math.max(max,Math.max(fCut,futhCut));
    //     }
    //     memo[n]=max;
    //     return max;
    // }
}