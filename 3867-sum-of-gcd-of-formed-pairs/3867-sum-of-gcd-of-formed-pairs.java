class Solution {
    public long gcdSum(int[] nums) {
        long maxi=0;
        long minGcd=Long.MAX_VALUE;
        long maxGcd=Long.MIN_VALUE;
        int n=nums.length;
        long prefix[]=new long[n];
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
            long currGcd=gcd(nums[i],maxi);
            prefix[i]=currGcd;
        }
        Arrays.sort(prefix);
        int l=0;
        int r=n-1;
        long sum=0;
        while(l<r){
            sum+=gcd(prefix[l],prefix[r]);
            l++;
            r--;
        }
        return sum;
        
    }
    public long gcd(long a,long b){
        while(b!=0){
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}