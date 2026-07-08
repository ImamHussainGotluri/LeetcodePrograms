class Solution {
    int mod = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long prefixSum[] = new long[n+1];
        long prefixProd[] = new long[n + 1];
        long pow[] = new long[n + 1];
        int nonZero[]=new int[n+1];
        
        pow[0] = 1;
        for (int i = 0; i < n; i++) {
            int dig = s.charAt(i) - '0';

            prefixProd[i + 1] = prefixProd[i];
            prefixSum[i+1]=prefixSum[i];
            nonZero[i+1]=nonZero[i];

            if(dig!=0){
                prefixProd[i + 1] = (prefixProd[i] * 10 + dig) % mod;
                prefixSum[i+1]=(prefixSum[i]+dig)%mod;
                nonZero[i+1]=nonZero[i]+1;
            }
            pow[i + 1] = (pow[i] * 10) % mod;
        }

        int m = queries.length;
        int ans[] = new int[m];
        int k = 0;
        for (int query[] : queries) {
            int l = query[0];
            int r = query[1];

            long sum=(prefixSum[r+1]-prefixSum[l]+mod)%mod;
            int len=nonZero[r+1]-nonZero[l];
            long prod=(prefixProd[r+1]-(prefixProd[l]*pow[len])%mod+mod)%mod;

            ans[k++] = (int) ((sum%mod)*(prod%mod)%mod);
        }
        return ans;
    }
}