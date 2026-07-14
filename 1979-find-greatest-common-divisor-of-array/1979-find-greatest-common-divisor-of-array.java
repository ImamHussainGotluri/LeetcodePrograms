class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int sm=nums[0];
        int lg=nums[n-1];
        return gcd(sm,lg);
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