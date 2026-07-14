class Solution {
    int mod = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int n=nums.length;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int dp[][][] = new int[n + 1][max + 1][max + 1];

        for (int rows[][] : dp) {
            for (int row[] : rows) {
                Arrays.fill(row, -1);
            }
        }
        return helper(nums, 0, 0, 0, dp);
    }

    public int helper(int nums[],int idx, int seq1, int seq2,int dp[][][]) {
        if (idx == nums.length) {
            return (seq1==seq2 && seq1!=0)?1:0;
        }

        if(dp[idx][seq1][seq2]!=-1){
            return dp[idx][seq1][seq2];
        }

       long left=helper(nums,idx+1,gcd(nums[idx],seq1),seq2,dp);
       long right=helper(nums,idx+1,seq1,gcd(seq2,nums[idx]),dp);
       long skip=helper(nums,idx+1,seq1,seq2,dp);

       int res=(int)((left + right+skip)%mod);

       dp[idx][seq1][seq2]=res;

        return res;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}