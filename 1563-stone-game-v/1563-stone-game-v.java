class Solution {
    int memo[][];
    int prefix[];
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;

        memo=new int[n][n];
        for(int row[]:memo){
            Arrays.fill(row,-1);
        }   

        prefix=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=stoneValue[i]+prefix[i];
        }

        return helper(0,n-1);
    }
    public int helper(int l,int r){
        if(l==r){
            return 0;
        }

        if(memo[l][r]!=-1){
            return memo[l][r];
        }

        int ans=0;
        for(int i=l;i<r;i++){
            int leftSum=prefix[i+1]-prefix[l];

            int rightSum=prefix[r+1]-prefix[i+1];

            if(leftSum<=rightSum){
                ans=Math.max(ans,leftSum+helper(l,i));
            }
            
            if(rightSum<=leftSum){
                ans=Math.max(ans,rightSum+helper(i+1,r));
            }
        }
        return memo[l][r]=ans;
    }
}