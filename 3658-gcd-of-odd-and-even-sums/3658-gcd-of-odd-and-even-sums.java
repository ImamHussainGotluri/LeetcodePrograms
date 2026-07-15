class Solution {
    public int gcdOfOddEvenSums(int n) {
        
        return gcd(n*n,n*(n+1));
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