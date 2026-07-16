class Solution {
    public long gcdSum(int[] nums) {
        int maxi=0;
        int n=nums.length;
        int prefix[]=new int[n];
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
            int currGcd=gcd(nums[i],maxi);
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
    public int gcd(int a,int b){
        while(b!=0){
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}