class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int diff[]=new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int a=nums[i];
            int b=nums[n-i-1];

            int low=1+Math.min(a,b);
            int high=limit+Math.max(a,b);
            int sum=a+b;

            diff[2]+=2;
            diff[low]-=1;
            diff[sum]-=1;
            diff[sum+1]+=1;
            diff[high+1]+=1;
        }
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=2;i<2*limit;i++){
            sum+=diff[i];
            min=Math.min(sum,min);
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}