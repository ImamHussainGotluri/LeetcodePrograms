class Solution {
    public int change(int amount, int[] coins) {
        
        int n=coins.length;
        int t[][]=new int[n+1][amount+1];
        for(int row[]:t){
            Arrays.fill(row,-1);
        }
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=amount;j++){
        //         if(i==0 ){
        //             t[i][j]=0;
        //         }
        //         if(j==0){
        //             t[i][j]=1;
        //         }
        //     }
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=amount;j++){
        //         if(coins[i-1]<=j){
        //             t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
        //         }
        //         else{
        //             t[i][j]=t[i-1][j];
        //         }
        //     }
        // }
        // return t[n][amount];
        // int t[][]=new int[]
        return MinCoins(coins,amount,coins.length,t);
    }
    public int MinCoins(int coins[],int cap,int n,int t[][]){
        if(cap==0){
            return 1;
        }
        if(cap<0 || n==0){
            return 0;
        }
        if(t[n][cap]!=-1){
            return t[n][cap];
        }
        int cnt=0;
        if(coins[n-1]<=cap){
            cnt+=MinCoins(coins,cap-coins[n-1],n,t)+MinCoins(coins,cap,n-1,t);
        }
        else{
            cnt+=MinCoins(coins,cap,n-1,t);
        }
        t[n][cap]=cnt;
        return t[n][cap];
    }
}