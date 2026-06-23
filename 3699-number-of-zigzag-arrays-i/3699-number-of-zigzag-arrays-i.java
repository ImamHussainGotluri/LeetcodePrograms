class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long mod=1000000007;
        int m=r-l+1;
        if(n==1){
            return m;
        }

        long up[]=new long[m];
        long down[]=new long[m];

        for(int j=0;j<m;j++){
            up[j]=j;
            down[j]=m-j-1;
        }

        for(int len=3;len<=n;len++){

            long prefixUp[]=new long[m+1];
            long prefixDown[]=new long[m+1];

            for(int i=0;i<m;i++){
                prefixUp[i+1]=(prefixUp[i]+up[i])%mod;
                prefixDown[i+1]=(prefixDown[i]+down[i])%mod;
            }

            long totalUp=prefixUp[m];
            long totalDown=prefixDown[m];

            long newUp[]=new long[m];
            long newDown[]=new long[m];
            for(int j=0;j<m;j++){
                newUp[j]=prefixDown[j];

                newDown[j]=(totalUp-prefixUp[j+1]+mod)%mod;
            }

            up=newUp;
            down=newDown;
        }
        long ans=0;
        for(int i=0;i<m;i++){
            ans=(ans+up[i]+down[i])%mod;
        }
        return (int)ans;
    }
}